package com.taizhou.taizhou_back.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taizhou.taizhou_back.mapper.UserMapper;
import com.taizhou.taizhou_back.pojo.AccessTokenDto;
import com.taizhou.taizhou_back.pojo.AuthTokenModel;
import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.pojo.User;
import com.taizhou.taizhou_back.service.UserService;
import com.taizhou.taizhou_back.utils.BaseResponse;
import com.taizhou.taizhou_back.utils.Constant;
import com.taizhou.taizhou_back.utils.EncryptUtil;
import com.taizhou.taizhou_back.utils.StatusCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public List<Permission> loadNavList() {
        return userMapper.loadNavList();
    }

    @Override
    public AuthTokenModel authUserAndCreateToken(String username, String password) throws Exception {
        User user = authUser(username,password);
        if (user != null){
            //失效掉以前仍然可以使用的accessToken
            //创建token对象
            AccessTokenDto accessTokenDto =
                    new AccessTokenDto(user.getId(),username,System.currentTimeMillis(), Constant.snowFlake.nextId().toString(),Constant.ACCESS_TOKEN_EXPIRE);
            //将对象转为字符串
            String accessTokenDtoJsonStr = objectMapper.writeValueAsString(accessTokenDto);
            //给定一个秘钥给字符串加密
            String accessToken = EncryptUtil.aesEncrypt(accessTokenDtoJsonStr, Constant.TOKEN_AUTH_KEY);
            //将token对象存储到redis中
            stringRedisTemplate.opsForValue().set(accessToken, JSON.toJSONString(user));
            stringRedisTemplate.expire(accessToken,3600L,TimeUnit.SECONDS);
            AuthTokenModel authTokenModel=new AuthTokenModel();
            authTokenModel.setAccessToken(accessToken);
            authTokenModel.setRoleName(user.getRoleName());
            return authTokenModel;
        }
        return null;
    }

//    用户登录验证
    public User authUser(String userName, String password)  {
        User user = userMapper.selUserInfoByName(userName);
        if(user == null){
            throw new RuntimeException("当前用户未注册。");
        }
        if(!password.equals(user.getPassword())){
            throw new RuntimeException("您输入的密码有误，请重新输入。");
        }
        return user;
    }

//    验证token
    @Override
    public BaseResponse validateToken(String accessToken) {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            if (StringUtils.isBlank(accessToken)) {
                return new BaseResponse(StatusCode.AccessTokenNotBlank);
            }
            //为了防止token伪造,会额外做异步操作解析token
            AccessTokenDto accessTokenDto;
            try {
                accessTokenDto = parseAccessToken(accessToken);
            } catch (Exception e) {
                return new BaseResponse(StatusCode.AccessTokenInvalidate);
            }
            if (accessTokenDto != null) {
                //判断token是否过期
                if (System.currentTimeMillis() - accessTokenDto.getTimestamp() > accessTokenDto.getExpire()) {
                    //失效token
                    this.invalidateByAccessToken(accessToken);
                    return new BaseResponse(StatusCode.TokenValidateExpireToken);
                }
            }
        } catch (Exception e) {
            return new BaseResponse(StatusCode.Fail, e.getMessage());
        }
        return response;
    }

    //    解析token
    public AccessTokenDto parseAccessToken(String accessToken) throws Exception {
        String tokenJsonStr = EncryptUtil.aesDecrypt(accessToken, Constant.TOKEN_AUTH_KEY);
        return objectMapper.readValue(tokenJsonStr, AccessTokenDto.class);
    }
    //    失效Token
    public void invalidateByAccessToken(String accessToken) {
        if (StringUtils.isNotBlank(accessToken)){
            stringRedisTemplate.delete(accessToken);
        }
    }
}
