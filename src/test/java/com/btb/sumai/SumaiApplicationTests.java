package com.btb.sumai;

import com.btb.sumai.service.Assistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.yaml")
@Import(TestConfig.class)
public class SumaiApplicationTests {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Test
    void contextLoads() {
        Assistant assistant = AiServices.create(Assistant.class, chatLanguageModel);
        String response = assistant.chat("generate top three albums of Miles Davis");
        assertThat(response).containsIgnoringCase("Kind of Blue");
    }

}
