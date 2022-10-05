package com.learn.restfulwebservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello Dat";
	}

	@GetMapping(path = "/hello-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello Bean");
	}
	
	@GetMapping(path = "/hello/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello Bean " + name);
	}
}
