package com.btb.sumai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.ollama.OllamaContainer;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

@TestConfiguration
@TestPropertySource(locations = "classpath:application-test.yaml")
public class TestConfig {

    public static final String MODEL_NAME = "tinyllama";
    private static final String OLLAMA_MODELS_PATH;

    static {
        OLLAMA_MODELS_PATH = FileUtils.getUserDirectoryPath() + File.separator + ".ollama";
        //noinspection ResultOfMethodCallIgnored
        new File(OLLAMA_MODELS_PATH).mkdirs();
    }

    @Bean
    public OllamaContainer ollamaContainer() throws IOException, InterruptedException {
        OllamaContainer ollama = new OllamaContainer("ollama/ollama")
                .withFileSystemBind(OLLAMA_MODELS_PATH, "/root/.ollama", BindMode.READ_WRITE);
        ollama.start();
        ollama.execInContainer("ollama", "pull", MODEL_NAME);
        return ollama;
    }

    @Bean
    @Primary
    public ChatLanguageModel ollamaTestChatModel(OllamaContainer ollama) {
        return OllamaChatModel.builder()
                .baseUrl(ollama.getEndpoint())
                .modelName(MODEL_NAME)
                .temperature(0.0)
                .timeout(Duration.ofMinutes(5))
                .logRequests(true)
                .logResponses(true)
                .build();
    }
}
