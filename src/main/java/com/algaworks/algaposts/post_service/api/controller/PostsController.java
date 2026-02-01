package com.algaworks.algaposts.post_service.api.controller;

import com.algaworks.algaposts.post_service.api.model.PostInput;
import com.algaworks.algaposts.post_service.api.model.PostMessageOutput;
import com.algaworks.algaposts.post_service.api.model.PostOutput;
import com.algaworks.algaposts.post_service.api.model.PostSummaryOutput;
import com.algaworks.algaposts.post_service.common.IdGenerator;
import com.algaworks.algaposts.post_service.domain.service.PostMessageService;
import io.hypersistence.tsid.TSID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.algaworks.algaposts.post_service.infrastructure.rabbitmq.RabbitMQQueueConstants.EXCHANGE;
import static com.algaworks.algaposts.post_service.infrastructure.rabbitmq.RabbitMQQueueConstants.ROUTING_KEY_RECEIVED;

@Slf4j
@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostsController {

    private final RabbitTemplate rabbitTemplate;
    private final PostMessageService postMessageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostOutput createPost(@RequestBody PostInput input) {
        PostMessageOutput message = toMessage(input);
        log.info("Conteúdo do post: {}", message);

        MessagePostProcessor messagePostProcessor = msg -> {
            msg.getMessageProperties().setHeader("postId", message.getPostId().toString());
            return msg;
        };

        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_RECEIVED, message, messagePostProcessor);

        postMessageService.save(input, message.getPostId());

        return toPostOutput(input, message.getPostId());
    }

    @GetMapping("/{postId}")
    public PostOutput getPost(@PathVariable TSID postId) {
        return null;
    }

    @GetMapping
    public Page<PostSummaryOutput> listPosts(@PageableDefault Pageable pageable) {
        return null;
    }

    private PostMessageOutput toMessage(PostInput input) {
        return PostMessageOutput.builder()
                .postId(IdGenerator.generateId())
                .postBody(input.getBody())
                .build();
    }

    private PostOutput toPostOutput(PostInput input, TSID postId) {
        return PostOutput.builder()
                .id(postId)
                .title(input.getTitle())
                .body(input.getBody())
                .author(input.getAuthor())
                .build();
    }
}
