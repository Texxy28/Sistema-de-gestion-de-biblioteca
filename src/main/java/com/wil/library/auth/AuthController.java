package com.wil.library.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wil.library.jwt.JwtUtil;
import com.wil.library.users.User;
import com.wil.library.users.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User dbUser = userService.userByEmail(user.getEmail());
        if (dbUser != null && user.getPassword().equals(dbUser.getPassword())) {
            String token = jwtUtil.getToken(user);
            return new ResponseEntity<String>(token, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Usuario no logueado", HttpStatus.UNAUTHORIZED);

    }

    @PostMapping("/register")
    public ResponseEntity<String> resgister(@RequestBody User user) {
        userService.newUser(user);
        String token = jwtUtil.getToken(user);
        return new ResponseEntity<String>(token, HttpStatus.OK);

    }

}
