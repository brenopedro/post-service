package com.algaworks.algaposts.post_service.domain.service;

import com.algaworks.algaposts.post_service.api.model.PostInput;
import com.algaworks.algaposts.post_service.domain.exception.PostNotFoundException;
import com.algaworks.algaposts.post_service.domain.model.PostEntity;
import com.algaworks.algaposts.post_service.domain.model.PostProcessedInput;
import com.algaworks.algaposts.post_service.domain.repository.PostMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostMessageService {

    private final PostMessageRepository postMessageRepository;

    public void save(PostInput input, UUID uuid) {
        log.info("Saving post message with ID: {}", uuid);

        PostEntity entity = PostEntity.builder()
                .postId(uuid)
                .title(input.getTitle())
                .body(input.getBody())
                .author(input.getAuthor())
                .build();

        postMessageRepository.save(entity);
        log.info("Post message with ID: {} saved successfully", uuid);
    }

    public void processPostMessage(PostProcessedInput input) {
        log.info("Processing post message...");

        PostEntity entity = findById(input.getPostId());
        entity.setWordCount(input.getWordCount());
        entity.setCalculatedValue(input.getCalculatedValue());
        postMessageRepository.saveAndFlush(entity);

        log.info("Post message processed and saved: {}", input);
    }

    public PostEntity findById(UUID postId) {
        log.info("Finding processed post with ID: {}", postId);
        return postMessageRepository.findById(postId)
                .orElseThrow(() -> {
                    log.error("Processed post with ID: {} not found", postId);
                    return new PostNotFoundException("Processed post not found");
                });
    }

    public Page<PostEntity> findAllByPostId(Pageable pageable) {
        return postMessageRepository.findAll(pageable);
    }
}
