package me.szeredniklaszlo.taskexecutor.rabbitmq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Data
public class TaskExecutorRabbitMQProperties {

	private Exchanges exchanges;
	private Queues queues;
	private RoutingKeys routingKeys;

	@Data
	public static class Exchanges {
		private String internal;
	}

	@Data
	public static class Queues {
		private String taskExecutor;
	}

	@Data
	public static class RoutingKeys {
		private String internalTaskExecutor;
	}
}
