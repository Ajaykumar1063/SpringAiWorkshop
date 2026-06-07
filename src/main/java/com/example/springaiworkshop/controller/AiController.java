package com.example.springaiworkshop.controller;

import com.example.springaiworkshop.service.AudioService;
import com.example.springaiworkshop.service.ChatService;
import com.example.springaiworkshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private AudioService audioService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/ask-ai")
    public String askAi(@RequestParam String prompt) {
        return chatService.askAI(prompt);
    }

    @GetMapping("/generate-audio")
    public String generateAudio(@RequestParam String text) {
        return audioService.convertTextToSpeech(text);
    }

    @GetMapping("/generate-image")
    public String generateImage(@RequestParam String text) {
        return imageService.generateImage(text);
    }

}
