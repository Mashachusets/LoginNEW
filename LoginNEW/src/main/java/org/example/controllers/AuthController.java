package org.example.controllers;

import io.swagger.annotations.*;
import lombok.extern.log4j.Log4j2;
import org.example.mapper.UserMapper;
import org.example.models.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Login and Registration Controller", description = "Controller used to handle signup and login requests.")
@Log4j2
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/auth",
        produces = { MediaType.APPLICATION_JSON_VALUE  })
public class AuthController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @Autowired
//    private PasswordEncoder encoder;

    //TODO: correction needed
//    @PostMapping("/signin")
//    @ApiOperation(value = "Signs in with user credentials",
//            notes = "If provided valid user credentials, signs in",
//            response = User.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "The user is successfully signed in"),
//            @ApiResponse(code = 400, message = "Missed required parameters, parameters are not valid"),
//            @ApiResponse(code = 401, message = "The request requires user authentication"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
//            @ApiResponse(code = 500, message = "Server error")})
//    public ResponseEntity<UserInfoResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//
//                .collect(Collectors.toList());
//    }

    @PostMapping("/signup")
    @ApiOperation(value = "Creates an account with user credentials",
            notes = "If provided valid user credentials, creates an account",
            response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The user account is successfully created"),
            @ApiResponse(code = 400, message = "Missed required parameters, parameters are not valid"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> registerUser (@RequestBody User user){
        log.info("Create new user by passing : {}", user);
        if (userRepository.existsByUsername(user.getUsername())) {
            log.warn("Username already exists");
            return ResponseEntity.badRequest().build();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            log.warn("User with this email already exists");
            return ResponseEntity.badRequest().build();
        }
        User userPost = userService.save(user);
        return new ResponseEntity<>(userPost, HttpStatus.CREATED);
    }

    //TODO: correction needed
//    @PostMapping("/signout")
//    @ApiOperation(value = "Logs out user of their account",
//            notes = "Logs out user of their account if user is logged in",
//            response = User.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "The user is successfully logged out of their account"),
//            @ApiResponse(code = 400, message = "Missed required parameters, parameters are not valid"),
//            @ApiResponse(code = 401, message = "The request requires user authentication"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
//            @ApiResponse(code = 500, message = "Server error")})
//    }
}