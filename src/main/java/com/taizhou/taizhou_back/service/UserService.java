package com.taizhou.taizhou_back.service;

import com.taizhou.taizhou_back.pojo.AuthTokenModel;
import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.utils.BaseResponse;

import java.util.List;

public interface UserService {
    List<Permission> loadNavList();

    String authUserAndCreateToken(String username, String password) throws Exception;

    BaseResponse validateToken(String accessToken);
}
