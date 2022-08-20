package com.bridgelabz.lmsproject.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Response {
    private String message;
    private int errorCode;
    private Object token;
    private Object data;

    public Response() {

    }

    public Response(String login_successful, int i, String token) {
    }
}
