package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

//    @Override
//    public ResultVo getList(Integer pageNo, Integer pageSize, Long id) {
//        ResultVo resultVo;
//
//        DataVo<Poor> dataVo;
//
//        List<Poor> poors;
//
//        if (id != null){
//            poors = new ArrayList<>();
//
//            PoorWithBLOBs poor = poorMapper.selectByPrimaryKey(id);
//
//            if (poor == null){
//                dataVo = new DataVo<>(0L, poors, pageNo, pageSize);
//
//                resultVo = new ResultVo(4100, "没有该贫困户", false, dataVo);
//            } else {
//                poors.add(poor);
//
//                dataVo = new DataVo<>(1L, poors, pageNo, pageSize);
//
//                resultVo = new ResultVo(2100, "查询该贫困户成功", true, dataVo);
//            }
//        } else {
//            PageHelper.startPage(pageNo, pageSize);
//
//            poors = poorMapper.selectByExample(null);
//
//            if (poors.size() == 0) {
//                dataVo = new DataVo<>(0L, poors, pageNo, pageSize);
//
//                resultVo = new ResultVo(4200, "没有贫困户信息", false, dataVo);
//            } else {
//                PageInfo<Poor> pageInfo = new PageInfo<>();
//
//                dataVo = new DataVo<>(pageInfo.getTotal(), poors, pageNo, pageSize);
//
//                resultVo = new ResultVo(2200, "贫困户信息查询成功", true, dataVo);
//            }
//        }
//
//        return resultVo;
//    }

    @Override
    public ResultVo add(PoorWithBLOBs poor) {
        ResultVo resultVo;

        if (poor.getCreateTime() == null) {
            poor.setCreateTime(new Date());
        }

        int affectedRows = poorMapper.insert(poor);

        if (affectedRows > 0) {
            resultVo = new ResultVo(2000, "贫困户添加成功", true, poor);
        } else {
            resultVo = new ResultVo(4000, "贫困户添加失败！！", false, null);
        }

        return resultVo;
    }
}
