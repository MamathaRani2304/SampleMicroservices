package com.webservice.practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class WelcomController {
//	@Value("${app.msg}")
//	String msg;
@GetMapping("/welcome")
public String welcome() {
	return "good morning";
}
@GetMapping("/invokeapi")
public ResponseEntity<String> invokeRest() {
	
	String url="https://api.coinbase.com/v2/currencies";
	RestTemplate r = new RestTemplate();
	
	String result = r.getForEntity(url, String.class).getBody();
	
	
	
	return new ResponseEntity<String>(result,HttpStatus.OK);
	
	
}
@GetMapping("/invokeapi2")
public ResponseEntity<String> getJoke(){
	String url ="https://v2.jokeapi.dev/joke/Any";
	WebClient wb  = WebClient.create();
				String output =	wb.get()
					.uri(url)
					.retrieve()
					.bodyToMono(String.class)
					.block();
				
					return new ResponseEntity<>(output,HttpStatus.OK);
					
					
}
}
