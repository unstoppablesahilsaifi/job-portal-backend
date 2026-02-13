package com.jobportal.service;

import com.jobportal.dto.UserRequestDto;
import com.jobportal.dto.UserResponseDto;
import com.jobportal.entity.User;
import com.jobportal.repository.UserRepository;
import com.jobportal.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    //  SINGLE CONSTRUCTOR (BEST PRACTICE)
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder passwordEncoder,JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    // Register New User
    public UserResponseDto registerUser(UserRequestDto dto) {

        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);

        UserResponseDto response = new UserResponseDto();
        response.setId((long) saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setRole(saved.getRole());

        return response;
    }



    public String loginUser(String email, String password){
        User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not Found"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(user.getEmail());
    }



}
