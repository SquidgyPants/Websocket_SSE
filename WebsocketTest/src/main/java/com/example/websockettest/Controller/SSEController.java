package com.example.websockettest.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.Executors;

@RestController
public class SSEController {

    @GetMapping("/events")
    public SseEmitter streamEvents() {
        SseEmitter emitter = new SseEmitter();

        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(1000); // simuleer delay
                    emitter.send("Bericht nummer " + i, MediaType.TEXT_PLAIN);
                }
                emitter.complete();
            } catch (IOException | InterruptedException e) {
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }

    @GetMapping("/")
    public String returnMessage() {
        return "dit werkt niet, maar de SSE wel!";
    }
}
