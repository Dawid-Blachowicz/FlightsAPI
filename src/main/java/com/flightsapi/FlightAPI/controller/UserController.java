package com.flightsapi.FlightAPI.controller;

import com.flightsapi.FlightAPI.dto.UserDTO;
import com.flightsapi.FlightAPI.entity.User;
import com.flightsapi.FlightAPI.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/verify/{token}")
    public String verifyUser(@PathVariable String token) {
        return userService.verify(token);
    }
}
