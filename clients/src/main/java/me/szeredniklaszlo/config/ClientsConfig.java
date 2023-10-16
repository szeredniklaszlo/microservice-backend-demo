package me.szeredniklaszlo.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootConfiguration
@PropertySource(value = {"classpath:clients-${spring.profiles.active:default}.properties"})
public class ClientsConfig {

}
