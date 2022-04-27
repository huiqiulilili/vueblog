package com.lyx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lyx.entity.Blog;
import com.lyx.mapper.BlogMapper;
import com.lyx.service.BlogService;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {
}
