package com.btb.sumai.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaChatModelConfig {

    @Value("${ollama.base-url:http://localhost:11434}")
    private String baseURL;

    @Value("${ollama.model-name:llama3.1}")
    private String modelName;

    @Bean
    ChatLanguageModel ollamaChatModel() {
        return OllamaChatModel.builder()
                .baseUrl(baseURL)
                .modelName(modelName)
                .temperature(0.7)
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}