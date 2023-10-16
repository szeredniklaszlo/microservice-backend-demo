package me.szeredniklaszlo.restapi.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.szeredniklaszlo.amqp.RabbitMQMessageProducer;
import me.szeredniklaszlo.clients.taskexecutor.TaskExecutorClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/rest-api")
@RequiredArgsConstructor
@Slf4j
public class TestController {
	private final TaskExecutorClient taskExecutorClient;
	private final RabbitMQMessageProducer rabbitMQMessageProducer;

	@PostMapping("/publish-and-hello")
	public String publishMessageAndCommunicateOnHttpSync(@RequestBody String message) {
		rabbitMQMessageProducer.publish(message, "internal.exchange", "internal.task-executor.routing-key");
		return taskExecutorClient.hello() + " László!";
	}
}
