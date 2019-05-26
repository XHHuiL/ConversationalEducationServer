package com.fudan.controller;


import com.fudan.entity.User;
import com.fudan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
