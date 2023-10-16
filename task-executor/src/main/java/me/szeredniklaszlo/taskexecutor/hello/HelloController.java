package me.szeredniklaszlo.taskexecutor.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	@GetMapping("/api/v1/task-executor/hello")
	public String hello() {
		log.info("HelloController > hello");
		return "Hello from TaskExecutor";
	}
}
