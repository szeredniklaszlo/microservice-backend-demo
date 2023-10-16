package me.szeredniklaszlo.taskexecutor.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class TaskExecutorRabbitMQConfig {

	private final TaskExecutorRabbitMQProperties taskExecutorRabbitMQProperties;

	@Bean
	public TopicExchange internalTopicExchange() {
		return new TopicExchange(taskExecutorRabbitMQProperties.getExchanges().getInternal());
	}

	@Bean
	public Queue taskExecutorQueue() {
		return new Queue(taskExecutorRabbitMQProperties.getQueues().getTaskExecutor());
	}

	@Bean
	public Binding taskExecutorQueueToInternalBinding() {
		return BindingBuilder
			.bind(taskExecutorQueue())
			.to(internalTopicExchange())
			.with(taskExecutorRabbitMQProperties.getRoutingKeys().getInternalTaskExecutor());
	}
}
