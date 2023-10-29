package com.app.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.services.LoginService;

@RestController
public class LoginValidationController {
    private final LoginService loginService;

    @Autowired
    public LoginValidationController(LoginService loginService) {
        this.loginService = loginService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public boolean CheckUser(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username != null && password != null) {
            return loginService.checkLogin(username, password);
        } else {
            return false;
        }
    }
}
