package com.example.demo.entities;

import com.example.demo.dtos.DTO;

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
