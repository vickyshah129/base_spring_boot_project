package com.project.util;

import org.springframework.http.HttpMethod;

public enum RestURL {

    USER_ID_AGAINST_TOKEN("/merchant/user_id", HttpMethod.GET),
    GET_CLIENT_DETAIL_AGAINST_TOKEN("/merchant/authentication", HttpMethod.GET);

    private RestURL(String url, HttpMethod requestMethod) {
        this.url = url;
        this.requestMethod = requestMethod;
    }
    private String url;
    private HttpMethod requestMethod;

    public String getUrl() {
        return url;
    }

    public HttpMethod getRequestMethod() {
        return requestMethod;
    }

}
