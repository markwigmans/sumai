package com.btb.sumai.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface TitleService {
    @SystemMessage("You are an expert at writing catchy blog post titles.")
    String generateTitle(@UserMessage String topic);
}