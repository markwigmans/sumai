package com.btb.sumai.controller;

import com.btb.sumai.service.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AssistantController {

    private final ChatLanguageModel model;

    @GetMapping("/assistant")
    public String assistant(@RequestParam(value = "message", defaultValue = "What time is it now?") String message) {
        Assistant assistant = AiServices.create(Assistant.class, model);
        return assistant.chat(message);
    }
}
