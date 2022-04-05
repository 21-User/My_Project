package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;


    @Override
    public Map<String, Object> add(Poor poor) {
        int affectedRows = poorMapper.insert((PoorWithBLOBs) poor);

        Map<String, Object> map = new HashMap<>();

        map.put("message", "添加失败！");
        map.put("code", 500);
        map.put("success", false);
        map.put("data", "失败");

        if (affectedRows > 0) {
            map.put("message", "添加成功！");
            map.put("code", 200);
            map.put("success", true);
            map.put("data", poor);
        }

        return map;
    }
}
