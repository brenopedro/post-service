package com.algaworks.algaposts.post_service.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostOutput {

    private String id;
    private String title;
    private String body;
    private String author;
    private Integer wordCount;
    private Double calculatedValue;
}
