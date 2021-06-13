package com.example.server.controller;

import com.example.server.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @PostMapping("/user/{userId}/name/{userName}")
    public User post(@RequestBody User user,
                     @PathVariable int userId,
                     @PathVariable String userName
                     )
    {

        log.info("client req Object :{}",user);
        log.info("client req Id:{}",userId);
        log.info("client req Name:{} ",userName);

        return user;
    }

}
