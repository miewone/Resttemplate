package com.example.server.controller;

import com.example.server.dto.Req;
import com.example.server.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Req<User> post(@RequestBody Req<User> user,
                     @PathVariable int userId,
                     @PathVariable String userName,
                     @RequestHeader("x-authorization") String authorization
                     )
    {

        log.info("client req Object :{}",user);
        log.info("client req Id:{}",userId);
        log.info("client req Name:{} ",userName);
        log.info("client req Header x-authorization :{} ",authorization);

        Req<User> res = new Req<>();
        res.setHeader(
                new Req.Header()
        );
        res.setInnerBody(user.getInnerBody());
        return res;
    }



}
