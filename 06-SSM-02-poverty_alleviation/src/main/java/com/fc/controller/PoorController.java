package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.User;
import com.fc.service.PoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @RequestMapping("add")
    public Map<String, Object> add(Poor poor) {
        return poorService.add(poor);
    }
}
