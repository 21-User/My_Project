package com.fc.controller;

import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MsgBoardService;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
public class MsgBoardController {
    @Autowired
    private MsgBoardService msgBoardService;

    @PostMapping("add")
    public ResultVo add(@RequestBody MessageBoardWithBLOBs msgBoard) {
        return msgBoardService.add(msgBoard);
    }

    @GetMapping("delete")
    public ResultVo delete(@RequestParam Long id) {
        return msgBoardService.delete(id);
    }

    @PostMapping("update")
    public ResultVo update(@RequestBody MessageBoardWithBLOBs msgBoard) {
        return msgBoardService.update(msgBoard);
    }

    @GetMapping("getList")
    public ResultVo getList(@RequestParam(value = "pageNo")Integer pageNo,
                            @RequestParam(value = "pageSize")Integer pageSize,
                            Long id) {
        return msgBoardService.getList(pageNo, pageSize, id);
    }

}
