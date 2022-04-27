package com.lyx.controller;

import com.lyx.common.Result;
import com.lyx.entity.User;
import com.lyx.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户controller层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getUserById")
    public Result getUserById(@RequestParam("id") Long id) {
        User  user =  userService.getById(id);
        if (StringUtils.isEmpty(user)) {
           return Result.fail("查询失败");
        }
        return Result.succ(user);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody User user) {
        boolean save = userService.save(user);
        if (save) {
            return Result.succ(save);
        }
        return Result.fail("保存失败");
    }
}
