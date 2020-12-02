package com.taizhou.taizhou_back.controller;


import com.taizhou.taizhou_back.pojo.AuthTokenModel;
import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.service.UserService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import com.taizhou.taizhou_back.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("user的controller")
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("loadNavList")
    @ApiOperation("加载导航列表")
    public BaseResponse<Permission> loadNavList(){
        List<Permission> list=userService.loadNavList();
        if (list!=null) return new BaseResponse(StatusCode.Success,list);
        else return new BaseResponse(StatusCode.Fail);
    }

    @RequestMapping("login")
    @ApiOperation("登录")
    public BaseResponse login(@RequestParam String username, @RequestParam String password){
        //判断用户名或者密码是否为空
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            //提示用户名密码不能为空
            return new BaseResponse(StatusCode.UserNamePasswordNotBlank);
        }
        BaseResponse<AuthTokenModel> baseResponse = new BaseResponse<>(StatusCode.Success);
        try {
            //登录并创建token
            baseResponse.setData(userService.authUserAndCreateToken(username,password));
        }catch (Exception e){
            return new BaseResponse<>(StatusCode.Fail.getCode(),e.getMessage());
        }
        return baseResponse;
    }
}
