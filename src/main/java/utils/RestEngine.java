package utils;

import com.squareup.okhttp.*;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import enums.RestMethod;
import rest.RestRequestStructure;
import rest.RestResponseStructure;

import java.io.IOException;
import java.net.Proxy;
import java.util.Map;

/**
 * class with static methods to interact with REST API of client application
 */
public class RestEngine {
    private OkHttpClient httpClient = new OkHttpClient();
    private String userName = null;
    private String userPwd = null;

    public void setBasicAuthentication(String username, String password) {
        this.userName = username;
        this.userPwd = password;
    }

    public RestResponseStructure sendRequest(RestRequestStructure request) throws IOException {
        RequestBody requestBody = null;
        if (!request.getMethod().equals(RestMethod.GET)) {
            requestBody = RequestBody.create(MediaType.parse(request.getContentType()),
                    request.getBody());
        }
        Request.Builder builder = new Request.Builder();
        builder.url(request.getUrl());
        builder.method(request.getMethod().toString(), requestBody);
        for (Map.Entry<String, String> header : request.getHeaders().entrySet())
            builder.addHeader(header.getKey(), header.getValue());

        Request httpRequest = builder.build();
        Response httpResponse = httpClient.newCall(httpRequest).execute();

        RestResponseStructure response = new RestResponseStructure();
        response.setCode(httpResponse.code());
        response.setBody(httpResponse.body().string());

        for (String headerName : httpResponse.headers().names())
            response.setHeader(headerName, httpResponse.header(headerName));

        return response;
    }
}