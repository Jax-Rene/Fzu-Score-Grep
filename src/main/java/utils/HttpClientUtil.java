package utils;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;

public final class HttpClientUtil {

    //超时设为10秒
    public static final int TIME_OUT = 10000;


    /**
     * 使用HttpClient重试机制的请求
     *
     * @param url
     * @param method
     * @param request
     * @return
     * @throws Exception
     */
    public static HttpResponse doRequestWithRetry(String url, HttpMethodEnum method, HttpRequest request,
                                                  String contentType)
            throws Exception {
        return doRequest(url, method, request, true, contentType);
    }


    /**
     * 不使用HttpClient重试机制的请求
     *
     * @param url
     * @param method
     * @param request
     * @return
     * @throws Exception
     */
    public static HttpResponse doRequestWithNoRetry(String url, HttpMethodEnum method, HttpRequest request,
                                                    String contentType)
            throws Exception {
        return doRequest(url, method, request, false, contentType);
    }

    private static HttpResponse doRequest(String url, HttpMethodEnum method, HttpRequest request, boolean isRetry,
                                          String contentType)
            throws Exception {
        if (StringUtils.isEmpty(url)) {
            throw new RuntimeException("url不能为空！！");
        }
        if (request == null) {
            throw new RuntimeException("request不能为空！！");
        }

        HttpResponse response = new HttpResponse();
        HttpClient client = null;
        HttpMethod httpMethod = null;

        try {
            //设置url
            if (method == HttpMethodEnum.GET) {
                httpMethod = new GetMethod(url);
            } else if (method == HttpMethodEnum.POST) {
                httpMethod = new PostMethod(url);
            } else {
                throw new RuntimeException("不支持的http方法！！");
            }

            //设置headers
            Map<String, String> headers = request.getHeaders();
            if (!CollectionUtils.isEmpty(headers)) {
                Set<String> headerNames = headers.keySet();
                for (String headerName : headerNames) {
                    httpMethod.setRequestHeader(headerName, headers.get(headerName));
                }
            }
            //如果是post,则设置body
            if (method == HttpMethodEnum.POST && StringUtils.isNotBlank(request.getBody())) {
                PostMethod postMethod = (PostMethod) httpMethod;
                RequestEntity entity = new StringRequestEntity(request.getBody(), contentType, "UTF-8");
                postMethod.setRequestEntity(entity);
            }
            client = new HttpClient();

            //是否使用httpClient的重试机制
            if (!isRetry) {
                DefaultHttpMethodRetryHandler httpMethodRetryHandler = new DefaultHttpMethodRetryHandler(0, false);
                client.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, httpMethodRetryHandler);
            }

            //设置连接超时及读取超时时间
            client.getHttpConnectionManager().getParams().setConnectionTimeout(TIME_OUT);
            client.getHttpConnectionManager().getParams().setSoTimeout(TIME_OUT);

            int status = client.executeMethod(httpMethod);
            String body = httpMethod.getResponseBodyAsString();
            Header[] responseHeaders = httpMethod.getResponseHeaders();

            response.setStatus(status);
            response.setBody(body);
            for (Header header : responseHeaders) {
                response.addHeader(header.getName(), header.getValue());
            }
        } finally {
            httpMethod.releaseConnection();
            ((SimpleHttpConnectionManager) client.getHttpConnectionManager()).shutdown();
        }

        return response;
    }

    private HttpClientUtil() {
    }
}
