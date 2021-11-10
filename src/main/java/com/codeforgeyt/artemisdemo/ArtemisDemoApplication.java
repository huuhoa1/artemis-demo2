package com.codeforgeyt.artemisdemo;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@SpringBootApplication
public class ArtemisDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtemisDemoApplication.class, args);
	}

	
	@Bean
	public JmsListenerContainerFactory<?> topicConnectionFactory(@Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory,
	                                                             DefaultJmsListenerContainerFactoryConfigurer configurer) {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    configurer.configure(factory, connectionFactory);
	    factory.setPubSubDomain(true);
	    return factory;
	}
}


