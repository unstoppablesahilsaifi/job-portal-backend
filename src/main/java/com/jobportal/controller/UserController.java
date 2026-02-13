package com.jobportal.controller;

import com.jobportal.dto.UserRequestDto;
import com.jobportal.dto.UserResponseDto;
import com.jobportal.entity.User;
import com.jobportal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // Register User API
    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(
            @RequestBody UserRequestDto userRequestDto) {

        UserResponseDto response =
                userService.registerUser(userRequestDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email,
                                          @RequestParam String password) {

        String token = userService.loginUser(email, password);

        return ResponseEntity.ok(token);
    }
}
