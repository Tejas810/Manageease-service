package com.app.controller;

import java.io.IOException;
import com.app.ReadProducts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductInfoController {
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/home")
    public ResponseEntity<String> getData() throws IOException {
        String jsonData = ReadProducts.readJsonFile();
        return ResponseEntity.ok(jsonData);
    }
}
