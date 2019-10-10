package com.jeff.contract.test.springcontracttest.springcontracttestconsumer.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

  private RestTemplate restTemplate = new RestTemplate();

  @GetMapping("/test")
  public String testController() {

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Content-Type", "application/json");

    //{"loanAmount":99999,"client.id":"test-clientid"}
    String body = "{\"loanAmount\":99999,\"client.id\":\"7993300490\"}";

    ResponseEntity<String> responseEntity = restTemplate
        .exchange("http://localhost:8090/fraudcheck", HttpMethod.PUT,
            new HttpEntity<>(body, httpHeaders), String.class);

    return responseEntity.getBody();
  }
}
