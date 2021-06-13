package com.example.client.controller;

import com.example.client.dto.UserResponse;
import com.example.client.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiController {

    private final RestTemplateService restTemplateService;

    @GetMapping("")
    public UserResponse getHello()
    {
        return restTemplateService.hello();
    }

    @PostMapping("")
    public UserResponse postHello()
    {
        return restTemplateService.post();
    }
}
