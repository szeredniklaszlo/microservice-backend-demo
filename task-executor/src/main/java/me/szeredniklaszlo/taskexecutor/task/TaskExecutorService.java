package me.szeredniklaszlo.taskexecutor.task;

import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskExecutorService {

	@SneakyThrows
	public void consume(String message) {
		Thread.sleep(4000);
		log.info("Message {} consumed in TaskExecutorService", message);
	}
}
