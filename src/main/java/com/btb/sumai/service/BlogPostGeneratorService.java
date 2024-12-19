package com.btb.sumai.service;

import com.btb.sumai.model.BlogPost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogPostGeneratorService {
    private final TitleService titleService;
    private final StructureService structureService;
    private final ContentService contentService;
    private final ConclusionService conclusionService;
    private final SeoService seoService;


    public BlogPost generateBlogPost(String topic) {
        String title = titleService.generateTitle(topic);
        String structure = structureService.generateStructure(topic);
        List<String> sections = parseSections(structure);

        List<String> contentSections = sections.stream()
                .map(section -> contentService.generateContent(topic, section))
                .collect(Collectors.toList());

        String conclusion = conclusionService.generateConclusion(topic);
        String keywords = seoService.generateKeywords(topic);

        return new BlogPost(title, contentSections, conclusion, keywords);
    }

    private List<String> parseSections(String structure) {
        // Implement logic to parse the structure into individual sections
        // This is a simplified version
        return Arrays.asList(structure.split("\n"));
    }
}
