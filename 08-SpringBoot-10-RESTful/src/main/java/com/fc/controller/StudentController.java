package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping
    public List<Student> findAll(){
        return service.findAll();
    }

    @PostMapping("{name}/{age}/{gender}/{info}")
    public Integer insert(Student student){
        return service.insert(student);
    }

    @PutMapping("{id}/{info}")
    public Integer update(@PathVariable("id") Integer id,
                          @PathVariable("info") String info){
        return service.update(id, info);
    }

    @DeleteMapping("{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
}
