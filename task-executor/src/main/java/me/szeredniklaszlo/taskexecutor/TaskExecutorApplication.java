package me.szeredniklaszlo.taskexecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import me.szeredniklaszlo.config.ClientsConfig;
import me.szeredniklaszlo.dal.DataAccessLayerConfig;

@SpringBootApplication(
	scanBasePackages = {
		"me.szeredniklaszlo.amqp",
		"me.szeredniklaszlo.taskexecutor"
	}
)
@EnableConfigurationProperties
@Import({ClientsConfig.class, DataAccessLayerConfig.class})
public class TaskExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskExecutorApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, TaskExecutorRabbitMQProperties taskExecutorRabbitMQProperties) {
		return args -> {
			producer.publish(
				new Person("Hello", 18),
				taskExecutorRabbitMQProperties.getExchanges().getInternal(),
				taskExecutorRabbitMQProperties.getRoutingKeys().getInternalTaskExecutor()
			);
		};
	}

	record Person(String name, int age) {}*/
}
