package com.taizhou.taizhou_back.service;

import com.taizhou.taizhou_back.pojo.Permission;

import java.util.List;

public interface UserService {
    List<Permission> loadNavList();
}
