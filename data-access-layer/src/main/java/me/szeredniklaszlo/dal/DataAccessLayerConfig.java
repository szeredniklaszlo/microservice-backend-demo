package me.szeredniklaszlo.dal;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
@EntityScan
@PropertySource(value = {"classpath:data-${spring.profiles.active:default}.properties"})
public class DataAccessLayerConfig {

}
