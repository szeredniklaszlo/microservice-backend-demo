package me.szeredniklaszlo.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import me.szeredniklaszlo.config.ClientsConfig;
import me.szeredniklaszlo.dal.DataAccessLayerConfig;

@SpringBootApplication(
	scanBasePackages = {
		"me.szeredniklaszlo.amqp",
		"me.szeredniklaszlo.restapi"
	}
)
@EnableFeignClients(basePackages = "me.szeredniklaszlo.clients")
@Import({ClientsConfig.class, DataAccessLayerConfig.class})
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
