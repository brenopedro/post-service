package com.algaworks.algaposts.post_service.infrastructure.rabbitmq;

import com.algaworks.algaposts.post_service.api.model.PostInput;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.algaworks.algaposts.post_service.infrastructure.rabbitmq.RabbitMQQueueConstants.PROCESSING_RESULT_QUEUE;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQListener {

//    private final TemperatureMonitoringService temperatureMonitoringService;
//    private final SensorAlertService sensorAlertService;

    @SneakyThrows
    @RabbitListener(queues = PROCESSING_RESULT_QUEUE, concurrency = "2-3")
    public void handlePostService(@Payload PostInput data,
                       @Headers Map<String, Object> headers) {

        log.info("Received data: {}", data);
        log.info("Received headers: {}", headers);

//        temperatureMonitoringService.processTemperatureReading(data);
    }
}
