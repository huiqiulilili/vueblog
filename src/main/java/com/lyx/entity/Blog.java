package com.lyx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("m_blog")

public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private Long userId; // 用户ID


    @NotBlank(message = "标题不能为空")
    private String title; // 标题

    @NotBlank(message = "摘要不能为空")
    private String description; // 照耀

    @NotBlank(message = "内容不能为空")
    private String content; // 内容

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime created; // 创建时间

    private Integer status; // 状态

}
