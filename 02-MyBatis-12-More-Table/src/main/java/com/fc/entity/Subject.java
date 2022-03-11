package com.fc.entity;

import lombok.Data;
import org.junit.Test;

import java.util.List;

@Data
public class Subject {
    private Integer id;
    private String name;
    List<Student> students;
}
