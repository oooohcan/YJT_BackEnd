package edu.web.yjt_backend.model.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value ="user")
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}