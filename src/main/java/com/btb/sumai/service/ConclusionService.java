package com.btb.sumai.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface ConclusionService {
    @SystemMessage("You are an expert at writing impactful blog post conclusions.")
    @UserMessage("Write a conclusion for a blog post about {topic}. Summarize key points and include a call-to-action.")
    String generateConclusion(String topic);
}