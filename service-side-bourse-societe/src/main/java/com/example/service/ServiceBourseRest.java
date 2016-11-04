package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ServiceBourseRest {
	@Value("${mail}")
	private String mail;

	@RequestMapping("/expediteur")
	public String getMail() {
		System.out.println("---------------------------------------------");
		System.out.println("this is me");
		System.out.println("---------------------------------------------");
		return mail;
	}
}
