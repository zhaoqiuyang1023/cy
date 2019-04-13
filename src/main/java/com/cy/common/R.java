package com.cy.common;

public class R<T> {

    private String message = "success";
    private String code = "0";
    private T data = null;


    public R(T data) {
        this.data = data;
    }

    public R(String message, String code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
