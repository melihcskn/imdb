package com.MovieSiteProject.api.controllers;

import com.MovieSiteProject.entities.model.ErrorResponse;
import com.MovieSiteProject.entities.model.LoginRequest;
import com.MovieSiteProject.entities.model.LoginResponse;
import com.MovieSiteProject.entities.model.RegisterRequest;
import com.MovieSiteProject.security.JwtUtil;
import com.MovieSiteProject.services.concretes.UserManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserManager userManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserManager userManager,PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userManager = userManager;
        this.passwordEncoder = passwordEncoder;
    }

    @ResponseBody
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest){
        try {
            Authentication authenticationRequest =
                    UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.getEmail(), loginRequest.getPassword());

            Authentication authenticationResponse =
                    authenticationManager.authenticate(authenticationRequest);

            String token = jwtUtil.createToken(authenticationResponse.getName());
            LoginResponse loginResponse = new LoginResponse(token);

            return ResponseEntity.ok(loginResponse);

        }catch (BadCredentialsException e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @ResponseBody
    @PostMapping(path = "/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterRequest registerRequest){
         try {
            registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            userManager.registerUser(registerRequest);

            String token = jwtUtil.createToken(registerRequest.getEmail());
            LoginResponse loginResponse = new LoginResponse(token);
            return ResponseEntity.ok(loginResponse);
        }catch (Exception e){
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }


}
