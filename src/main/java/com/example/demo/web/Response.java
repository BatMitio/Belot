package com.example.demo.web;

import com.example.demo.dtos.interfaces.DTO;

public class Response {
    public String message;
    public DTO data;

    public Response() {
    }

    public Response(String message, DTO data) {
        this.message = message;
        this.data = data;
    }
}
