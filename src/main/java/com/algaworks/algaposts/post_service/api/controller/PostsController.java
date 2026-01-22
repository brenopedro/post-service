package com.algaworks.algaposts.post_service.api.controller;

import com.algaworks.algaposts.post_service.api.model.PostInput;
import com.algaworks.algaposts.post_service.api.model.PostOutput;
import com.algaworks.algaposts.post_service.api.model.PostSummaryOutput;
import io.hypersistence.tsid.TSID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostsController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostOutput createPost(PostInput input) {
        return null;
    }

    @GetMapping("/{postId}")
    public PostOutput getPost(@PathVariable TSID postId) {
        return null;
    }

    @GetMapping
    public Page<PostSummaryOutput> listPosts(@PageableDefault Pageable pageable) {
        return null;
    }
}
