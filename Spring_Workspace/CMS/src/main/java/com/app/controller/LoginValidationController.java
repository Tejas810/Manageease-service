package com.app.controller;
import com.dto.LoginResponse;
import com.nimbusds.jwt.JWTClaimsSet;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.services.JwtTokenProvider;
import com.app.services.LoginService;

@RestController
public class LoginValidationController<Claims> {

    private final LoginService loginService;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginValidationController(LoginService loginService, JwtTokenProvider jwtTokenProvider) {
        this.loginService = loginService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody Map<String, String> loginData) throws Exception {
        String username = loginData.get("username");
        String password = loginData.get("password");

        if (username != null && password != null && loginService.checkLogin(username, password)) {
            String token = jwtTokenProvider.generateToken(username);
            JWTClaimsSet claimsSet = jwtTokenProvider.extractClaims(token);

            return ResponseEntity.ok(new LoginResponse(true, token,claimsSet));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(false, null, null));
        }
    }
    
}
