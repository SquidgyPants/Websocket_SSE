package com.example.websockettest.Config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
    // This class can be used to handle WebSocket messages
    // You can implement methods to handle incoming messages, send responses, etc.

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received: " + message.getPayload());
        session.sendMessage(new TextMessage("Hello from server!"));
    }
//
//    // Example method to handle a message
//    public void handleMessage(String message) {
//        // Process the incoming message
//        System.out.println("Received message: " + message);
//
//        // Here you can add logic to send a response back if needed
//    }
//
//    // You can also add methods to handle connection open/close events, etc.
//    public void onOpen() {
//        System.out.println("WebSocket connection opened.");
//    }
//    public void onClose() {
//        System.out.println("WebSocket connection closed.");
//    }
//    public void onError(Throwable error) {
//        System.err.println("WebSocket error: " + error.getMessage());
//    }
}
