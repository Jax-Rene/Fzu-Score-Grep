package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaonl on 2015/8/7.
 */
public class HttpResponse {
    private int status = -1;
    private Map<String, String> headers;
    private String body;

    public void addHeader(String name, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        this.headers.put(name, value);
    }

    public String getHeader(String name) {
        if (headers == null) {
            return null;
        }
        return headers.get(name);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public void setBody(String body) {
        this.body = body;
    }
}
