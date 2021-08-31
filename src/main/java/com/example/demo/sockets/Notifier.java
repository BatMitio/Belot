package com.example.demo.sockets;

import com.example.demo.sockets.frames.ClientFrame;
import com.example.demo.sockets.frames.TeamFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class Notifier {
    @Autowired
    private static SimpMessagingTemplate messenger;
    private static String userDestination = "/secure";

    public static void notifyClient(String user, ClientFrame clientFrame){
        messenger.convertAndSendToUser(user, userDestination, clientFrame);
    }

    public static void notifyTeam(String teamCode, TeamFrame teamFrame){
        messenger.convertAndSend("/team/" + teamCode, teamFrame);
    }
}
