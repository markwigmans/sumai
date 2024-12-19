package com.btb.sumai.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface SeoService {
    @SystemMessage("You are an SEO expert. Generate relevant keywords for blog posts.")
    @UserMessage("Generate 5-7 SEO keywords for a blog post about {topic}")
    String generateKeywords(String topic);
}
