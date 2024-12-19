package com.btb.sumai.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BlogPost {
    private String title;
    private List<String> content;
    private String conclusion;
    private String keywords;
}