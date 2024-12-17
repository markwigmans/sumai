package com.btb.sumai.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class PerplexityChatModelConfig {
    @Value("${perplexity.base-url:https://api.perplexity.ai}")
    private String baseURL;

    @Value("${perplexity.model-name:llama-3.1-sonar-small-128k-online}")
    private String modelName;

    @Value("${perplexity.api-key}")
    private String apiKey;

    @Bean
    public ChatLanguageModel perplexityChatModel() {
        return OpenAiChatModel.builder()
                .apiKey(apiKey)
                .baseUrl(baseURL)
                .modelName(modelName)
                .temperature(0.7)
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}