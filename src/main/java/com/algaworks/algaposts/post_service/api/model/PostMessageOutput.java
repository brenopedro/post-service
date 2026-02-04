package com.algaworks.algaposts.post_service.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class PostMessageOutput {

    private UUID postId;
    private String postBody;
}
