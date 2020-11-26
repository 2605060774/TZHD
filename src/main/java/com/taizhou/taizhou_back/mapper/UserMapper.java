package com.taizhou.taizhou_back.mapper;

import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.pojo.User;

import java.util.List;

public interface UserMapper {
    List<Permission> loadNavList();

    User selUserInfoByName(String userName);
}
