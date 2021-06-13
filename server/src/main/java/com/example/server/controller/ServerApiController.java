package com.example.server.controller;

import com.example.server.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/server")
@RequiredArgsConstructor
public class ServerApiController {

    @GetMapping("")
    public User hello(@RequestParam String name,@RequestParam int age)
    {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
