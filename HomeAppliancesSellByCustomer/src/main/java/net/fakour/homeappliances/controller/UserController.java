package net.fakour.homeappliances.controller;

import net.fakour.homeappliances.entity.UserEntity;
import net.fakour.homeappliances.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public UserEntity login(@RequestBody UserEntity users) {

        return userService.login(users);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserEntity users) {
        return userService.register(users);

    }
}
