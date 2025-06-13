package com.example.demo.service;

import com.example.demo.model.MangoModel;
import com.example.demo.repository.MangoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MangoService {

    @Autowired
    private MangoRepository mangoRepository;

    public MangoModel saveApple(MangoModel apple) {
        return mangoRepository.save(apple);
    }

    public List<MangoModel> getAllApples() {
        return mangoRepository.findAll();
    }
}
