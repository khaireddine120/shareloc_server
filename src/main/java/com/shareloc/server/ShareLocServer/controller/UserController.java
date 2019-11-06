package com.shareloc.server.ShareLocServer.controller;

import com.shareloc.server.ShareLocServer.exception.ResourceNotFoundException;
import com.shareloc.server.ShareLocServer.model.User;
import com.shareloc.server.ShareLocServer.repository.UserRepository;
import com.shareloc.server.ShareLocServer.security.CurrentUser;
import com.shareloc.server.ShareLocServer.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
