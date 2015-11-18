package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuangjy on 2015/11/18.
 */
public class HttpRequest {
    private Map<String, String> headers;
    private String body;

    public void addHeader(String name, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        this.headers.put(name, value);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }
}
