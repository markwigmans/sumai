package com.btb.sumai;

import com.btb.sumai.service.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.BindMode;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.ollama.OllamaContainer;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
class SumaiApplicationTests {

    private static final String MODEL_NAME = "tinyllama";
    private static final String OLLAMA_MODELS_PATH;

    static {
        OLLAMA_MODELS_PATH = FileUtils.getUserDirectoryPath() + File.separator + ".ollama";
        new File(OLLAMA_MODELS_PATH).mkdirs();
    }

    @Container
    static OllamaContainer ollama = new OllamaContainer("ollama/ollama")
            .withFileSystemBind(OLLAMA_MODELS_PATH, "/root/.ollama", BindMode.READ_WRITE);

    private static ChatLanguageModel model;

    @BeforeAll
    static void setUp() throws IOException, InterruptedException {
        String ollamaUrl = String.format("http://%s:%d", ollama.getHost(), ollama.getFirstMappedPort());
        model = OllamaChatModel.builder()
                .baseUrl(ollamaUrl)
                .modelName(MODEL_NAME)
                .temperature(0.0)
                .timeout(Duration.ofMinutes(5))
                .build();

        // Pull the model explicitly
        ollama.execInContainer("ollama", "pull", MODEL_NAME);
    }

    @Test
    void contextLoads() {
        Assistant assistant = AiServices.create(Assistant.class, model);
        String response = assistant.chat("generate top three albums of Miles Davis");
        assertThat(response).containsIgnoringCase("Kind of Blue");
    }

}
