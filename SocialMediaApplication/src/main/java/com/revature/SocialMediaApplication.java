package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocialMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaApplication.class, args);
	}

	/*
	What is Spring?
	Spring is an umbrella term that refers to a family of different frameworks all under the Spring name.
	Most of these frameworks as Spring Projects -> This is a plug-and-play framework designed to be added to your
	application based off specific business needs (SQL-> Spring Data JPA, Web Traffic -> Spring Web, Security -> Spring
	security).

	How does Spring do what it does?
	Spring manages your various classes as a something called a Spring Bean. It also uses the dependency injection
	design pattern to maintain dependencies

	What is Spring Boot?
	Spring Boot is a particularly influential Spring Project designed to speed up the process of building your app and
	allowing you to "boot up" faster than before

	There should some sort of component scan and configuration annotations to get this application to read our beans
	but where are they?
	@SpringBootApplication is an annotation that belongs to Spring boot that combines three different annotations
	- @Configuration
	- @ComponentScan
	- @EnableAutoConfiguration TODO circle back later

	Annotations are going to be a big piece of using Spring Boot and various Spring Projects so we'll try to keep
	track of all of them
	 */

}
