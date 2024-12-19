package com.btb.sumai.controller;

import com.btb.sumai.model.BlogPost;
import com.btb.sumai.service.BlogPostGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
public class BlogPostController {

    private final BlogPostGeneratorService blogPostGeneratorService;


    @PostMapping("/generate")
    public ResponseEntity<BlogPost> generateBlogPost(@RequestParam String topic) {
        BlogPost blogPost = blogPostGeneratorService.generateBlogPost(topic);
        return ResponseEntity.ok(blogPost);
    }
}