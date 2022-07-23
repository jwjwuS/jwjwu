package com.jwjwu.admin.test.controller;

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
    public String index(){
        return TestUtils.getTestStr("admin");
    }
}