package com.example.demo.sockets.structures.frames;

import com.example.demo.sockets.structures.interfaces.Data;

public class TeamFrame {
    private String event;
    private Data data;

    public TeamFrame(String event, Data data) {
        this.event = event;
        this.data = data;
    }
}
