package com.example.demo;
import javax.annotation.PostConstruct;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckSpringBootConnection {
	
	@GetMapping("/a")
	public String print(@RequestParam(value="name",defaultValue="springboot")String name) {
		
		return String.format("Hello %s", name);
	}
}
