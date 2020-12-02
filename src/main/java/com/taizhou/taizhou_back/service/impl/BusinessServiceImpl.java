package com.taizhou.taizhou_back.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.taizhou.taizhou_back.mapper.BusinessMapper;
import com.taizhou.taizhou_back.pojo.PbItemApplyInfo;
import com.taizhou.taizhou_back.pojo.User;
import com.taizhou.taizhou_back.service.BusinessService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import com.taizhou.taizhou_back.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public BaseResponse addApplyInfo(PbItemApplyInfo pbItemApplyInfo) {
        if(pbItemApplyInfo.getToken()!=null) {
            String  s = stringRedisTemplate.opsForValue().get(pbItemApplyInfo.getToken());
            User user = JSONObject.parseObject(s, User.class);
            pbItemApplyInfo.setCreateUserId(user.getId().toString());
            pbItemApplyInfo.setApplyPersonId(user.getId().toString());
        }
        int i=businessMapper.addApplyInfo(pbItemApplyInfo);
        if(i==0) return new BaseResponse(StatusCode.Fail);
        else return new BaseResponse(StatusCode.Success,pbItemApplyInfo);
    }

    @Override
    public BaseResponse showApplyInfo(String token) {
        if (token!=null){
            String  s = stringRedisTemplate.opsForValue().get(token);
            User user=JSONObject.parseObject(s, User.class);
            PbItemApplyInfo applyInfo=businessMapper.showApplyInfo(user.getId());
            if (applyInfo!=null){
                return new BaseResponse(StatusCode.Success,applyInfo);
            }else{
                return new BaseResponse(StatusCode.Fail);
            }
        }else {
            return new BaseResponse(StatusCode.Fail);
        }
    }

    @Override
    public BaseResponse showApplyInfoByStatus() {
        PbItemApplyInfo applyInfo=businessMapper.showApplyInfoByStatus();
            if (applyInfo!=null ){
                return new BaseResponse(StatusCode.Success,applyInfo);
            }else{
                return new BaseResponse(StatusCode.Fail);
            }

    }

    @Override
    public BaseResponse updateApplyStatus(String token, String itemName, Integer status) {
        if (token!=null) {
            String s = stringRedisTemplate.opsForValue().get(token);
            User user = JSONObject.parseObject(s, User.class);
            businessMapper.updateApplyStatus(itemName,user.getId(),status);
            return new BaseResponse(StatusCode.Success);
        }else{
            return new BaseResponse(StatusCode.Fail);
        }
    }
}
