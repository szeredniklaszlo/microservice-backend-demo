package me.szeredniklaszlo.taskexecutor.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import me.szeredniklaszlo.taskexecutor.task.TaskExecutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskExecutorRabbitMQConsumer {

	private final TaskExecutorService taskExecutorService;

	@RabbitListener(queues = "${rabbitmq.queues.task-executor}")
	public void consumer(String message) {
		log.info("Consumed {} from queue via @RabbitListener consumer", message);
		taskExecutorService.consume(message);
	}
}
