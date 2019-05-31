package com.fudan.controller;


import com.fudan.request.LoginRequest;
import com.fudan.response.LoginResponse;
import com.fudan.service.HttpClientService;
import com.fudan.service.UserService;
import com.fudan.util.UrlBuilder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final HttpClientService httpClientService;

    @Autowired
    public UserController(UserService userService, HttpClientService httpClientService) {
        this.userService = userService;
        this.httpClientService = httpClientService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse authenticate(@RequestBody LoginRequest request) throws IOException {
        if (request.getCode() == null || request.getCode().length() == 0) {
            return new LoginResponse(-1, "code should not be empty", null);
        }
        JSONObject json = httpClientService.getOpenId(UrlBuilder.urlForAppId(request.getCode()));
        if (json == null) {
            return new LoginResponse(-1, "can't getOpenId openid", null);
        }
        JSONObject tokenJson = httpClientService.getToken(json.toString());
        return new LoginResponse(1, "login success", (String) tokenJson.get("token"));
    }

}
