package rest;

import enums.RestMethod;
import utils.RestEngine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestRequestStructure {

    private String url;
    private RestMethod method;
    private Map<String, String> headers = new HashMap<>();
    private String contentType = "application/json; charset=utf-8";
    private String body;

    public RestRequestStructure() {
    }

    public RestRequestStructure(String url, RestMethod method) {
        this.url = url;
        this.method = method;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void putHeader(String headerName, String headerValue) {
        headers.put(headerName, headerValue);
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public RestMethod getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public RestResponseStructure executeBasic() throws IOException {
        return RestEngine.sendRequest(this);
    }

    public String getReportMessageHeader() {
        return String.format("Method: %s URL: %s", this.method.toString(), this.url);
    }

    public String getReportMessageBody() {
        StringBuilder sb = new StringBuilder("HEADERS:\n");
        if (this.headers != null)
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue());
                sb.append(sb.length() - 1);
                sb.append("\n");
            }
        sb.append("BODY:\n");
        if (this.body != null)
            sb.append(this.body).append("\n");
        return sb.toString();
    }
}