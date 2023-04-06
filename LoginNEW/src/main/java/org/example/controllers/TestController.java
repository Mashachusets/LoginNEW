package org.example.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.example.models.ERole;
import org.example.models.User;
import org.example.repository.UserRepository;
import org.example.repository.model.UserDAO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "Retrieve Information Controller", description = "Controller uses accessing protected resource methods with role based validations.")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    @ApiOperation(value = "Finds all user accounts status info",
            notes = "Returns the entire list of user accounts",
            response = User.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
        public ResponseEntity<List<User>> findAllUsers(Model theModel) {
            List<User> list = userService.findAll();
            return ResponseEntity.ok(list);
        }

    @GetMapping("/user/{username}")
    @ApiOperation(value = "Finds user account",
            notes = "Returns user account",
            response = User.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<UserDAO>> getByUsername(@PathVariable String username) {
        return new ResponseEntity<List<UserDAO>>(userRepository.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    @ApiOperation(value = "Finds all user accounts status info",
            notes = "Returns the entire list of user accounts",
            response = User.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<UserDAO>> getByRoleUsers(@RequestParam(required=false) String roleType) {
        List<UserDAO> userList = userRepository.findByRoleType(ERole.USER);
        return ResponseEntity.ok(userList);
    }

    @GetMapping("/mod")
    @ApiOperation(value = "Finds all moderator accounts status info",
            notes = "Returns the entire list of moderator accounts",
            response = User.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<UserDAO>> getAllUsersByRoleId(@RequestParam(required=false) String roleType) {
        List<UserDAO> modList = userRepository.findByRoleType(ERole.MODERATOR);
        return new ResponseEntity<>(modList, HttpStatus.OK);
    }

    @GetMapping("/admin")
    @ApiOperation(value = "Finds all moderator accounts status info",
            notes = "Returns the entire list of moderator accounts",
            response = User.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The request has succeeded", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 401, message = "The request requires user authentication"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The server has not found anything matching the Request-URI"),
            @ApiResponse(code = 500, message = "Server error")})
    public ResponseEntity<List<UserDAO>> getByRoleAdmins(@RequestParam(required=false) String roleType) {
        List<UserDAO> adminList = userRepository.findByRoleType(ERole.ADMIN);
        return ResponseEntity.ok(adminList);
    }
}