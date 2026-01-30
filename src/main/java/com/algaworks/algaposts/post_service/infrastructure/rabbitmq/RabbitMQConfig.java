package com.algaworks.algaposts.post_service.infrastructure.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.json.JsonMapper;

import java.util.HashMap;
import java.util.Map;

import static com.algaworks.algaposts.post_service.infrastructure.rabbitmq.RabbitMQQueueConstants.*;


@Configuration
public class RabbitMQConfig {

    @Bean
    public JacksonJsonMessageConverter jacksonJsonMessageConverter(JsonMapper jsonMapper) {
        return new JacksonJsonMessageConverter(jsonMapper);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue queuePostService() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "");
        args.put("x-dead-letter-routing-key", DEAD_LETTER_PROCESSING_RESULT_QUEUE);
        return QueueBuilder.durable(PROCESSING_RESULT_QUEUE)
                .withArguments(args).build();
    }

    @Bean
    public Queue deadLetterQueuePostService() {
        return QueueBuilder.durable(DEAD_LETTER_PROCESSING_RESULT_QUEUE).build();
    }

    @Bean
    public Binding bindingPostService() {
        return BindingBuilder.bind(queuePostService())
                .to(exchange())
                .with(ROUTING_KEY_PROCESSING);
    }

    @Bean
    public DirectExchange exchange() {
        return ExchangeBuilder.directExchange(EXCHANGE).build();
    }
}
