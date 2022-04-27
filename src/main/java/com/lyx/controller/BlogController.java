package com.lyx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyx.common.Result;
import com.lyx.entity.Blog;
import com.lyx.service.BlogService;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    // 获取所有博客
    @RequestMapping("blogs")
    public Result blogs(@RequestParam(defaultValue = "1") Integer currentPage,
                        @RequestParam(defaultValue = "5") Integer limit) {

        // 创建page对象
        Page page = new Page(currentPage,limit);

        // 调用方法实现条件查询分页
        blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        List data = page.getRecords();
        long total = page.getTotal(); // 获取总记录数

        Map<String ,Object> map = new HashMap<>();
        map.put("total",total);
        map.put("data",data);

        return Result.succ(map);
    }

    // 根据id查询博客
    public Result getBlogById(@RequestParam("id") Long id) {
        Blog blog = blogService.getById(id);
        if (StringUtils.isEmpty(blog)) {
           return Result.fail("该博客已被删除");
        }

        return Result.succ(blog);
    }

    // 编辑/保存博客
    public Result edit(@Validated @RequestBody Blog blog) {
        Blog temp = null;
        if(!StringUtils.isEmpty(blog)) {
            temp = blogService.getById(blog.getId());
        }else {
            temp = new Blog();
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");

        boolean b = blogService.saveOrUpdate(temp);
        if (b) {
            return Result.succ(null);
        }
        return Result.fail(null);
    }
}
