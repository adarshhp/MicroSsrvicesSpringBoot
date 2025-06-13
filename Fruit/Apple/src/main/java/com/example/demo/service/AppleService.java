package com.example.demo.service;

import com.example.demo.model.AppleModel;
import com.example.demo.repository.AppleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppleService {

    @Autowired
    private AppleRepository appleRepository;

    public AppleModel saveApple(AppleModel apple) {
        return appleRepository.save(apple);
    }

    public List<AppleModel> getAllApples() {
        return appleRepository.findAll();
    }
}
