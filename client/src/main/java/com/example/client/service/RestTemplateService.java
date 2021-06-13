package com.example.client.service;

import com.example.client.dto.UserRequest;
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

    public UserResponse post()
    {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(100,"park")
                .toUri();

        log.info("uri : {}",uri);


        UserRequest req = new UserRequest();
        req.setAge(10);
        req.setName("park");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> res = restTemplate.postForEntity(uri,req,UserResponse.class);

        log.info("response statusCode :{}",res.getStatusCode());
        log.info("response getHeader :{}",res.getHeaders());
        log.info("response getBody :{}",res.getBody());
        return res.getBody();
    }
}
