package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LLMService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final LLMService llmService;

    public ChatController(LLMService llmService) {
        this.llmService = llmService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> chat(@RequestBody Map<String, String> payload) {
        String message = payload.get("message");
        // For the global widget, we don't have specific course context yet.
        // In a real app, we might track the user's current page or last visited course.
        // For now, we'll provide a general educational assistant context.
        String context = "You are CogniAI, a helpful educational assistant on the CogniLearn platform. " +
                "The platform offers courses in AI, Machine Learning, Web Development, and Competitive Programming. " +
                "Help the student with general questions or guide them to their courses.";

        String response = llmService.chatWithCourse(message, context);
        return ResponseEntity.ok(Map.of("response", response));
    }
}
