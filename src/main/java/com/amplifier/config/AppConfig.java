package com.amplifier.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.amplifier.repositories", "com.amplifier.services", "com.amplifier.aspects" })
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
