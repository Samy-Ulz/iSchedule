/*
 * ISchedule
 * This class is responsible for the authentication of the users
 *
 * Author:      Samuel Ulz
 * Last Change: 24.04.2025
 */

package com.campus02.prg2_ischedule.controller;

import com.campus02.prg2_ischedule.dto.LoginRequest;
import com.campus02.prg2_ischedule.model.User;
import com.campus02.prg2_ischedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ).orElseThrow(() -> new NoSuchElementException("Username or password is incorrect or not registered"));
    }
}
