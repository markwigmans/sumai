package com.btb.sumai.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface StructureService {
    @SystemMessage("You are an expert at creating well-structured blog post outlines.")
    @UserMessage("Create a detailed outline for a blog post about {topic}. Include an introduction, main sections, and a conclusion.")
    String generateStructure(String topic);
}
