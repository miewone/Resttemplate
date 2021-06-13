package com.example.client.service;

import com.example.client.dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class RestTemplateService {

    public UserResponse hello()
    {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server")
                .queryParam("name","park")
                .queryParam("age",10)
                .encode()
                .build()
                .toUri();

        log.info("url toString :{}",uri.toString());

        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri,String.class);
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri,UserResponse.class);

        log.info("result getStatusCode :{}",result.getStatusCode());
        log.info("result getBody : {}",result.getBody());

        return result.getBody();
    }
}