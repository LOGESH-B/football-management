package com.football.football.controller;


public class FootballRes<T> {
    private String message;
    private T data;
    public FootballRes(String message, T data) {
        this.message = message;
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    
    
}
