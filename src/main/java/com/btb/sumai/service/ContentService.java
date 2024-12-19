package com.btb.sumai.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface ContentService {
    @SystemMessage("You are an expert blog writer. Write detailed, engaging content for the given section of a blog post.")
    @UserMessage("Write the content for the following section of a blog post about {topic}: {section}")
    String generateContent(String topic, String section);
}
