package com.fc.entity;

import java.awt.*;

public class Car {
    private Float speed;
    private String color;


    public Car(Float speed, String color) {
        this.speed = speed;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                '}';
    }
}   
