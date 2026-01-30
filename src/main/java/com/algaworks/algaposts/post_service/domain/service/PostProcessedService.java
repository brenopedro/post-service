package com.algaworks.algaposts.post_service.domain.service;

import com.algaworks.algaposts.post_service.domain.model.PostProcessedInput;
import com.algaworks.algaposts.post_service.domain.repository.PostProcessedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostProcessedService {

    private final PostProcessedRepository processedRepository;

    public void processPostMessage(PostProcessedInput input) {
        log.info("Processing post message...");
        processedRepository.save(input);
        log.info("Post message processed and saved: {}", input);
    }
}
