package org.example.controller;

import com.alibaba.fastjson.JSON;
import org.example.database.mapper.SchoolMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DatabaseController {
    @Resource
    private SchoolMapper schoolMapper;

    @GetMapping("/list")
    public String listUser() {
        return JSON.toJSONString(schoolMapper.selectList());
    }
}
