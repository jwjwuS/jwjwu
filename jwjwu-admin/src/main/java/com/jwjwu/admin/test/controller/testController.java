package com.jwjwu.admin.test.controller;

import com.jwjwu.common.utils.Result;
import com.jwjwu.common.utils.TestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试
 */
@RestController
@RequestMapping("test")
public class testController {

    @GetMapping("index")
    public Result index(){
        return new Result().ok("admin访问成功");
    }
}