package com.example.demo.controller;

import com.example.demo.model.AppleModel;
import com.example.demo.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apple")
public class AppleController {

    @Autowired
    private AppleService appleService;

    @PostMapping
    public AppleModel createApple(@RequestBody AppleModel apple) {
        return appleService.saveApple(apple);
    }

    @GetMapping
    public List<AppleModel> getAllApples() {
        return appleService.getAllApples();
    }
}
