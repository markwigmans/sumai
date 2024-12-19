package com.btb.sumai.config;


import com.btb.sumai.service.*;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiServicesConfig {

    @Bean
    public Assistant assistant(ChatModelService service) {
        return AiServices.builder(Assistant.class)
                .chatLanguageModel(service.getChatModel("ollamaChatModel"))
                .build();
    }

    @Bean
    public TitleService titleService(ChatModelService service) {
        return AiServices.builder(TitleService.class)
                .chatLanguageModel(service.getChatModel("ollamaChatModel"))
                .build();
    }

    @Bean
    public StructureService structureService(ChatModelService service) {
        return AiServices.builder(StructureService.class)
                .chatLanguageModel(service.getChatModel("ollamaChatModel"))
                .build();
    }

    @Bean
    public ContentService contentService(ChatModelService service) {
        return AiServices.builder(ContentService.class)
                .chatLanguageModel(service.getChatModel("ollamaChatModel"))
                .build();
    }

    @Bean
    public ConclusionService conclusionService(ChatModelService service) {
        return AiServices.builder(ConclusionService.class)
                .chatLanguageModel(service.getChatModel("ollamaChatModel"))
                .build();
    }

    @Bean
    public SeoService seoService(ChatModelService service) {
        return AiServices.builder(SeoService.class)
                .chatLanguageModel(service.getChatModel("ollamaChatModel"))
                .build();
    }
}
