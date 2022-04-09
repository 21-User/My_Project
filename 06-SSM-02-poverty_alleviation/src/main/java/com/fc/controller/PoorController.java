package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @PostMapping("add")
    public ResultVo add(@RequestBody PoorWithBLOBs poor) {
        return poorService.add(poor);
    }

//    @GetMapping("getList")
//    public ResultVo getList(@RequestParam(value = "pageNo")Integer pageNo,
//                            @RequestParam(value = "pageSize")Integer pageSize,
//                            Long id) {
//        return poorService.getList(pageNo, pageSize, id);
//    }

}
