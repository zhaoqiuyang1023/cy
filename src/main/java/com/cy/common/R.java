package com.cy.common;


import lombok.Data;

@Data
public class R<T> {

    private String message = "success";
    private String code = "0";
    private T data = null;


    public R(T data) {
        this.data = data;
    }

    public R( T data,String message) {
        this.message = message;
        this.data = data;
    }

    public R( T data,String code,String message) {
        this.message = message;
        this.code = code;
        this.data = data;
    }
}
