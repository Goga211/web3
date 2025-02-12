package com.example.lab3.service;

import com.example.lab3.model.Result;
import com.example.lab3.repository.ResultRepository;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.List;

public class ResultService {

    private final ResultRepository resultRepository = new ResultRepository();

    public void save(Result result) {
        resultRepository.save(result);
    }

    public List<Result> loadResults() {
        return resultRepository.findAll();
    }

}
