package rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestResponseStructure {
    private int code;
    private Map<String, String> headers;
    private String body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setHeader(String name, String value) {
        if (headers == null)
            headers = new HashMap<>();
        headers.put(name, value);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReportMessageBody() {
        StringBuilder sb = new StringBuilder("STATUS CODE: ");
        sb.append(this.getCode()).append("\n");
        sb.append("HEADERS:\n");
        if (this.headers != null)
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue());
                sb.append("\n");
            }
        sb.append("BODY:\n");
        if (this.body != null)
            sb.append(this.body).append("\n");
        return sb.toString();
    }
}
