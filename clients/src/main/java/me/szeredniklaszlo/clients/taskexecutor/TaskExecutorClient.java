package me.szeredniklaszlo.clients.taskexecutor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
	name = "task-executor"//,
	//url = "${clients.task-executor.url}"
	// commented out because eureka-server will provide the url for this feign client via the name
)
public interface TaskExecutorClient {
	@GetMapping("/api/v1/task-executor/hello")
	String hello();
}
