package com.btb.sumai.service;

import dev.langchain4j.service.SystemMessage;

public interface Assistant {

    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
}
