package com.btb.sumai;

import com.btb.sumai.service.Assistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestConfig.class)
public class SumaiApplicationTests {

    @Autowired
    private Assistant assistant;

    @Test
    void contextLoads() {
        String response = assistant.chat("generate top three albums of Miles Davis");
        assertThat(response).containsIgnoringCase("Kind of Blue");
    }

}
