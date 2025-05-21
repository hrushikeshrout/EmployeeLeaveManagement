package com.project.employeeleavemanagement.controller;


import com.project.employeeleavemanagement.dto.LoginRequest;
import com.project.employeeleavemanagement.dto.UserDTO;
import com.project.employeeleavemanagement.entity.Users;
import com.project.employeeleavemanagement.mapper.UsersMapper;
import com.project.employeeleavemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://192.168.1.1:3000")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        try {
            userService.saveNewUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginRequest loginRequest) {

        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        System.out.println("Received login attempt: Username = " + userName);
        UserDTO user = UsersMapper.toDTO(userService.login(userName, password));
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
        }
        return ResponseEntity.ok(user); // Send userId and other details to the frontend
    }
}