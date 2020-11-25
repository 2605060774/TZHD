package com.taizhou.taizhou_back.service.impl;

import com.taizhou.taizhou_back.mapper.UserMapper;
import com.taizhou.taizhou_back.pojo.Permission;
import com.taizhou.taizhou_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Permission> loadNavList() {
        return userMapper.loadNavList();
    }
}
