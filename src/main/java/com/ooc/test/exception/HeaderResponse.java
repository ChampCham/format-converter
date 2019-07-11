package com.ooc.test.exception;

import org.springframework.http.HttpHeaders;

import java.time.LocalDateTime;

public class HeaderResponse{
    private HttpHeaders headers;

    public HeaderResponse() {
        this.headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");

    }

    public HttpHeaders addAll(LocalDateTime timestamp, String type, String message, String url){
        this.headers.add("timestamp", String.valueOf(timestamp));
        this.headers.add("type", type);
        this.headers.add("message", message);
        this.headers.add("url",url);
        return this.headers;
    }
}
