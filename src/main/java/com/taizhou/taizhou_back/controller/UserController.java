package com.taizhou.taizhou_back.controller;


import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.service.UserService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import com.taizhou.taizhou_back.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("user的controller")
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("loadNavList")
    @ApiOperation("加载导航列表")
    public BaseResponse loadNavList(){
        List<Permission> list=userService.loadNavList();
        if (list!=null) return new BaseResponse(StatusCode.Success,list);
        else return new BaseResponse(StatusCode.Fail);
    }
}
