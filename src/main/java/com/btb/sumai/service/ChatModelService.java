package com.btb.sumai.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class ChatModelService {

    private final ConfigurableApplicationContext context;
    private final ChatLanguageModel primary;

    @Autowired
    public ChatModelService(ConfigurableApplicationContext context) {
        this.context = context;
        this.primary = getPrimary();
    }

    public ChatLanguageModel getChatModel(String modelType) {
        return Objects.requireNonNullElseGet(primary, () -> context.getBean(modelType, ChatLanguageModel.class));
    }

    ChatLanguageModel getPrimary() {
        final Map<String, ChatLanguageModel> beans = context.getBeansOfType(ChatLanguageModel.class);
        for (Map.Entry<String, ChatLanguageModel> entry : beans.entrySet()) {
            String beanName = entry.getKey();
            if (context.getBeanFactory().getBeanDefinition(beanName).isPrimary()) {
                return entry.getValue();
            }
        }
        return null;
    }
}
