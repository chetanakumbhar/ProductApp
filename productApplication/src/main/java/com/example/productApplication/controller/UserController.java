package com.example.productApplication.controller;

import com.example.productApplication.domain.User;
import com.example.productApplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/api/product/v1/")
public class UserController {
    @Autowired
    IUserService iUserService;

    //        http://localhost:8081/api/product/v1/add-user
    @PostMapping("/add-user")
    public ResponseEntity addUser(@RequestBody User user)
    {
       return new ResponseEntity(iUserService.addUser(user), HttpStatus.OK);
    }

    // http://localhost:8081/api/product/v1/get-user
    @GetMapping("/get-user")
    public ResponseEntity getUser(HttpServletRequest httpServletRequest)
    {
        String email = (String) httpServletRequest.getAttribute("attr1");
        return new ResponseEntity(iUserService.getUser(email),HttpStatus.OK);
    }

    // http://localhost:8081/api/product/v1/get-admin
    @GetMapping("/get-admin")
    public ResponseEntity getByAdmin(HttpServletRequest httpServletRequest)
    {
        if(httpServletRequest.getAttribute("attr2") != null && httpServletRequest.getAttribute("attr2").equals("Role_Admin"))
        {
            return new ResponseEntity<>(iUserService.getAllUserByAdmin(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Ur Not Authorized to access this link...",HttpStatus.BAD_REQUEST);
        }

    }
}
