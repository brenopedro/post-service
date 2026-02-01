package com.algaworks.algaposts.post_service.domain.service;

import com.algaworks.algaposts.post_service.api.model.PostInput;
import com.algaworks.algaposts.post_service.domain.model.PostEntity;
import com.algaworks.algaposts.post_service.domain.model.PostId;
import com.algaworks.algaposts.post_service.domain.repository.PostMessageRepository;
import io.hypersistence.tsid.TSID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostMessageService {

    private final PostMessageRepository postMessageRepository;

    public void save(PostInput input, TSID tsid) {
        log.info("Saving post message with ID: {}", tsid);

        PostEntity entity = PostEntity.builder()
                .postId(new PostId(tsid))
                .title(input.getTitle())
                .body(input.getBody())
                .author(input.getAuthor())
                .build();

        postMessageRepository.save(entity);
        log.info("Post message with ID: {} saved successfully", tsid);
    }
}
