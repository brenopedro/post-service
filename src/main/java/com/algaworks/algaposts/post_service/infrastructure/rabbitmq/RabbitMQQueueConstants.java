package com.algaworks.algaposts.post_service.infrastructure.rabbitmq;

public class RabbitMQQueueConstants {

    public static final String EXCHANGE = "post-service.post-received.v1.e";
    public static final String ROUTING_KEY_PROCESSING = "post-service.post-processing-result.v1.rk";
    public static final String ROUTING_KEY_RECEIVED = "post-service.post-received.v1.rk";
    public static final String DEAD_LETTER_PROCESSING_RESULT_QUEUE = "post-service.post-processing-result.v1.dlq";
    public static final String PROCESSING_RESULT_QUEUE = "post-service.post-processing-result.v1.q";
}
