package me.szeredniklaszlo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Capability;
import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class MicrometerConfig {

	@Bean
	public Capability capability(MeterRegistry registry) {
		return new MicrometerCapability(registry);
	}
}
