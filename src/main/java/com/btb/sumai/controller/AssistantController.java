package com.btb.sumai.controller;

import com.btb.sumai.service.Assistant;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assistant")
class AssistantController {

    private final Assistant assistant;

    @GetMapping("/")
    public String assistant(@RequestParam(value = "message", defaultValue = "What time is it now?") String message) {
        return assistant.chat(message);
    }
}
