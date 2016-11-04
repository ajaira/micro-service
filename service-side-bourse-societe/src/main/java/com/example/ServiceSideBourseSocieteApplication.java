package com.example;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.example.dao.SocieteRepository;
import com.example.entities.Societe;

@EnableBinding(Sink.class)
@EnableEurekaClient
@SpringBootApplication
@IntegrationComponentScan
public class ServiceSideBourseSocieteApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(
				ServiceSideBourseSocieteApplication.class, args);
		SocieteRepository societeRepository = context
				.getBean(SocieteRepository.class);

		Stream.of("societeA", "societeB", "societeC").forEach(
				s -> societeRepository.save(new Societe(s)));

		societeRepository.findAll()
				.forEach(s -> System.out.println(s.getNom()));

	}

	@MessageEndpoint
	class MessageSocieteReceiver {

		@Autowired
		SocieteRepository societeRepository;

		@ServiceActivator(inputChannel = Sink.INPUT)
		public void acceptNewSociete(String societeName) {
			System.out.println("Received reservation name: " + societeName);
			this.societeRepository.save(new Societe(societeName));
		}

	}

	@Configuration
	class Myconfig extends RepositoryRestMvcConfiguration {
		@Override
		protected void configureRepositoryRestConfiguration(
				RepositoryRestConfiguration config) {
			config.exposeIdsFor(Societe.class);
		}
	}
}
