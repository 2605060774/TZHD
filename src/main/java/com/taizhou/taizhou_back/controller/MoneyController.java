package com.taizhou.taizhou_back.controller;

import com.taizhou.taizhou_back.pojo.PbItemInfo;
import com.taizhou.taizhou_back.service.MoneyService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import com.taizhou.taizhou_back.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("保证金controller")
@RestController
@RequestMapping("money")
public class MoneyController {
    @Resource
    private MoneyService moneySservice;

    @RequestMapping("/principalCheck")
    @ApiOperation("项目负责人保证金退付列表")
    public Map principalCheck(){
        List<PbItemInfo> list = moneySservice.principalCheck();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }

    @RequestMapping("/backMoney")
    @ApiOperation("退回保证金")
    public BaseResponse backMoney(Integer applyId){
        System.out.println(applyId);
        int i = moneySservice.backMoney(applyId);
        if (i>0){
            return new BaseResponse(StatusCode.Success,i);
        }
        return new BaseResponse(StatusCode.Fail);

    }

    @RequestMapping("/normalMoney")
    @ApiOperation("正常保证金")
    public Map normalMoney(){
        List<PbItemInfo> list = moneySservice.normalMoney();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }

    @RequestMapping("/anormalMoney")
    @ApiOperation("异常保证金")
    public Map anormalMoney(){
        List<PbItemInfo> list = moneySservice.anormalMoney();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }

    @RequestMapping("/financeCheck")
    @ApiOperation("财务审核保证金列表")
    public Map financeCheck(){
        List<PbItemInfo> list = moneySservice.financeCheck();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }

    @RequestMapping("/financeBack")
    @ApiOperation("财务退回保证金")
    public BaseResponse financeBack(Integer applyId){
        System.out.println(applyId);
        int i = moneySservice.financeBack(applyId);
        if (i>0){
            return new BaseResponse(StatusCode.Success,i);
        }
        return new BaseResponse(StatusCode.Fail);
    }

    @RequestMapping("/alreadyBack")
    @ApiOperation("已办理退回")
    public Map alreadyBack(){
        List<PbItemInfo> list = moneySservice.alreadyBack();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }

    @RequestMapping("/itemShow")
    @ApiOperation("保证金缴纳查询")
    public Map itemShow(){
        List<PbItemInfo> list = moneySservice.itemShow();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }

    @RequestMapping("/payMoney")
    @ApiOperation("保证金已缴纳")
    public Map payMoney(){
        List<PbItemInfo> list = moneySservice.payMoney();
        Map map = new HashMap();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("data",list);
        map.put("count",1);
        return map;
    }
}
