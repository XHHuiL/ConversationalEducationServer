package com.fudan.response;


public class LoginResponse {
    private int status;
    private String message;
    private String token;
    private String openId;
    private String sessionKey;

    public LoginResponse(int status, String message, String token, String openId, String sessionKey) {
        this.status = status;
        this.message = message;
        this.token = token;
        this.openId = openId;
        this.sessionKey = sessionKey;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public String getOpenId() {
        return openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }
}