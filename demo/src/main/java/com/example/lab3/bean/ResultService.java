package com.example.lab3.bean;

import com.example.lab3.model.Result;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class ResultService {

    @Inject
    private ResultRepository resultRepository;

    public void save(Result result) {
        resultRepository.save(result);
    }

    public List<Result> loadResults() {
        return resultRepository.findAll();
    }

}
