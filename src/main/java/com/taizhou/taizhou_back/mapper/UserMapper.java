package com.taizhou.taizhou_back.mapper;

import com.taizhou.taizhou_back.pojo.Permission;

import java.util.List;

public interface UserMapper {
    List<Permission> loadNavList();
}
