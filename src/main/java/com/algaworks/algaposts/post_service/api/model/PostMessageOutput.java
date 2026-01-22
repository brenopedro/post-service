package com.algaworks.algaposts.post_service.api.model;

import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostMessageOutput {

    private TSID postId;
    private String postBody;
}
