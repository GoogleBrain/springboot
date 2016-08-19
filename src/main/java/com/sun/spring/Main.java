package com.sun.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.sun.spring")
public class Main extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	// ÐÞ¸ÄtomcatÆô¶¯¶Ë¿Ú;
	public void customize(ConfigurableEmbeddedServletContainer cc) {
		cc.setPort(1234);
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}