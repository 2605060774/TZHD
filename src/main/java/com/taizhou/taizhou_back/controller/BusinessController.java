package com.taizhou.taizhou_back.controller;


import com.taizhou.taizhou_back.pojo.PbItemApplyInfo;
import com.taizhou.taizhou_back.service.BusinessService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("业务办理模块business的controller")
@RequestMapping("business")
@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @PostMapping("addApplyInfo")
    public BaseResponse addApplyInfo( PbItemApplyInfo pbItemApplyInfo){
        return businessService.addApplyInfo(pbItemApplyInfo);
    }

    @PostMapping("showApplyInfo")
    public BaseResponse showApplyInfo(String token){
        return businessService.showApplyInfo(token);
    }

    @PostMapping("showApplyInfoByStatus")
    public BaseResponse showApplyInfoByStatus(){
        return businessService.showApplyInfoByStatus();
    }

    @PostMapping("updateApplyStatus")
    public BaseResponse updateApplyStatus(String token,String itemName,Integer status){
        return businessService.updateApplyStatus(token,itemName,status);
    }
}
