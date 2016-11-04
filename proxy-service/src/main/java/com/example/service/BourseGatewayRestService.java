package com.example.service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableCircuitBreaker
@RestController
@RequestMapping("/societes")
public class BourseGatewayRestService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	@Output(Source.OUTPUT)
	private MessageChannel outputChannelSource;

	@RequestMapping(method = RequestMethod.POST)
	public void write(@RequestBody Societe s) {
		System.out.println("Received reservation request: " + s.toString());
		this.outputChannelSource.send(MessageBuilder.withPayload(s.getNom())
				.build());

	}

	public Collection<String> fallback() {
		return Collections.emptyList();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(value = "/names")
	public Collection<String> listSocietes(
	// @RequestParam(defaultValue = "0") int page,
	/* @RequestParam(defaultValue = "3") int size */) {
		ParameterizedTypeReference<Resources<Societe>> responseType = new ParameterizedTypeReference<Resources<Societe>>() {
		};
		return restTemplate
				.exchange("http://societe-service/societes", HttpMethod.GET,
						null, responseType).getBody().getContent().stream()
				.map(Societe::getNom).collect(Collectors.toList());
	}

}

class Societe {
	private long id;
	private String nom;

	public Societe() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNom(String nomSociete) {
		this.nom = nomSociete;
	}

	@Override
	public String toString() {
		return "Societe [id=" + id + ", nom=" + nom + "]";
	}

}