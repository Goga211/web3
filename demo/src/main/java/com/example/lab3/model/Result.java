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

    @Column(name = "result")
    private String result;

    @Column(name = "execution_time")
    private long executionTime;

    @Column(name = "current_time")
    private Timestamp currentTime;

    public Result(float x, float y, float r, String result, long executionTime, Timestamp currentTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;  // Присваиваем строку
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

    public String getResult() {
        return result;  // Возвращаем строку
    }

    public void setResult(String result) {
        if ("Y".equals(result) || "N".equals(result)) {  // Проверка на допустимые значения
            this.result = result;
        } else {
            throw new IllegalArgumentException("Result must be 'Y' or 'N'");
        }
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return String.format("{x: %.2f, y: %.2f, r: %.2f, result: %s, executionTime: %s, currentTime: %s}",
                x, y, r, result, executionTime, currentTime);
    }
}
