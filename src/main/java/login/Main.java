package login;

import utils.*;


/**
 * Created by zhuangjy on 2015/11/18.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("======================首先登陆会收到302重定向======================");
        String url = "http://59.77.226.32/logincheck.asp";
        String body = "muser=031202338&passwd=123123&x=42&y=19";
        HttpRequest request = new HttpRequest();
        request.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        request.addHeader("Connection", "keep-alive");
        request.setBody(body);
        HttpResponse httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.POST, request,
                MediaTypes.TEXT_PLAIN);
        int status = httpResponse.getStatus();
        String responseBody = httpResponse.getBody();
        System.out.println("返回代码:" + status);
        System.out.println("返回body:");
        System.out.println(responseBody);

        System.out.println("======================下面的请求获取cookie======================");
        Integer index = responseBody.indexOf("id=") + 3;
        Integer last = responseBody.indexOf("&", index);
        String id = responseBody.substring(index, last);
        index = responseBody.indexOf("num=");
        String num = responseBody.substring(index+4);
//        url =



        System.out.println("======================下面是进入教务处======================");


        url = "http://59.77.226.35/default.aspx?id=" + id;
        request = new HttpRequest();
        request.addHeader("Cookie",cookie);
        httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.GET, request, MediaTypes.TEXT_PLAIN);
        status = httpResponse.getStatus();
        String result = httpResponse.getBody();
        System.out.println(status);
        System.out.println(result);

        System.out.println("======================下面是AJAX请求======================");
        url = "http://59.77.226.35/student/jscp/TeaList.aspx?id=" + id + "&bj=score";
        httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.GET, request, MediaTypes.TEXT_PLAIN);
        status = httpResponse.getStatus();
        result = httpResponse.getBody();
        System.out.println(status);
        System.out.println(result);


        System.out.println("======================下面是AJAX获取成绩======================");
        url = "http://59.77.226.35/student/xyzk/cjyl/score_sheet.aspx?id=" + id;
        httpResponse = HttpClientUtil.doRequestWithNoRetry(url, HttpMethodEnum.GET, request, MediaTypes.TEXT_PLAIN);
        status = httpResponse.getStatus();
        result = httpResponse.getBody();
        System.out.println(status);
        System.out.println(result);


        //获取cookie
//        String cookieHeader = httpResponse.getHeader("Set-Cookie");
//        Integer index = cookieHeader.indexOf("=");
//        Integer last = cookieHeader.indexOf(";");
//        String cookie = "ASP.NET_SessionId=" + cookieHeader.substring(index,last);
//        System.out.println("COOKIE:" + cookie);
    }
}
