package com.example.lab3.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float x;
    private float y;
    private float r;
    private boolean result;

    @Column(name = "execution_time")
    private long executionTime;
    @Column(name = "сгккуте_time")
    private Timestamp currentTime;

    public Result(float x, float y, float r, boolean result, long executionTime, Timestamp currentTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.executionTime = executionTime;
        this.currentTime = currentTime;
    }

    public Result() {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp nowTime) {
        this.currentTime = nowTime;
    }

    @Override
    public String toString() {
        return String.format("{x: %.2f, y: %.2f, r: %.2f, result: %b, executionTime: %s, currentTime: %s}",
                x, y, r, result, executionTime, currentTime);
    }

}