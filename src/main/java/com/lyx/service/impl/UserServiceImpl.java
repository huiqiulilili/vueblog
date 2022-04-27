package com.lyx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.entity.User;
import com.lyx.mapper.UserMapper;
import com.lyx.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
