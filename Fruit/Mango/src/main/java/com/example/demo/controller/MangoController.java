package com.example.demo.controller;

import com.example.demo.model.MangoModel;
import com.example.demo.service.MangoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mango")
public class MangoController {

    @Autowired
    private MangoService mangoService;

    @PostMapping
    public MangoModel createApple(@RequestBody MangoModel apple) {
        return mangoService.saveApple(apple);
    }

    @GetMapping
    public List<MangoModel> getAllApples() {
        return mangoService.getAllApples();
    }
}
