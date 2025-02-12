package com.example.lab3.bean;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("sliderBean")
@ViewScoped
public class SliderBean implements Serializable {
    private int value;

    // Getter и Setter для значения слайдера
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        System.out.println(value);
        this.value = value;
    }
}
