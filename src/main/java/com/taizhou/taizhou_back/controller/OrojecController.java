package com.taizhou.taizhou_back.controller;


import com.taizhou.taizhou_back.pojo.PbItemInfo;
import com.taizhou.taizhou_back.pojo.PbRule;
import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.service.OrojecService;
import com.taizhou.taizhou_back.service.UserService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import com.taizhou.taizhou_back.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("user的controller")
@RequestMapping("orojec")
@RestController
public class OrojecController {

    @Resource
    private OrojecService orojecService;


    /*预约订单展示*/
    @RequestMapping("orojecShow")
    @ResponseBody
    @ApiOperation("项目办理信息展示")
    public Map<String,Object> orojecShow(PbItemInfo pbItemInfo) {
        System.out.println("123");
        List<PbItemInfo> list = orojecService.orojecShow(pbItemInfo);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("data",list);
        map.put( "msg","suc");
        map.put("count",list.size());
        return map;
    }

    @RequestMapping("biddingRules")
    @ResponseBody
    @ApiOperation("竞价规则添加")
    public BaseResponse appFenLeibyId(PbRule pbRule) throws Exception {
        int i  = orojecService.biddingRules(pbRule);
        System.out.println(pbRule);
        return new BaseResponse(200,"success0",pbRule) ;
    }

    /*预约订单展示*/
    @RequestMapping("orojecshenhe")
    @ResponseBody
    @ApiOperation("责任审核")
        public Map<String,Object> orojecshenhe(PbItemInfo pbItemInfo) {
            List<PbItemInfo> list = orojecService.orojecshenhe(pbItemInfo);
            System.out.println(list);
            System.out.println("??");
            Map<String,Object> map=new HashMap<>();
            map.put("code",0);
            map.put("data",list);
            map.put( "msg","suc");
            map.put("count",list.size());

            return map;
        }

    @RequestMapping("rojecbyId")
    @ResponseBody
    @ApiOperation("成交确认书")
    public BaseResponse rojecbyId(PbItemInfo pbItemInfo)  {
        System.out.println(135);
        System.out.println(pbItemInfo);
        int i  = orojecService.rojecbyId(pbItemInfo);
        return new BaseResponse(200,"success0",pbItemInfo) ;
    }
}
