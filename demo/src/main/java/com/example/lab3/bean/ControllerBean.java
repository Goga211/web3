package com.example.lab3.bean;

import com.example.lab3.model.Result;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("controllerBean")
@SessionScoped
public class ControllerBean implements Serializable {

    private float x;
    private float y;
    private float r;

    @Inject
    DotCheckerBean dotCheckerBean;

    private final ResultService resultService = new ResultService();
    private final List<Result> resultList = new ArrayList<>();

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void completeRequest() {
        Result result = dotCheckerBean.checkAndCalculatePoint();
        System.out.println(result);
        resultService.save(result);
        resultList.add(result);
    }

    public List<Result> getResultList() {
        return resultService.loadResults();
    }
}
