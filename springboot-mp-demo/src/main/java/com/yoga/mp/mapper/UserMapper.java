package com.yoga.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yoga.mp.pojo.User;

public interface UserMapper extends BaseMapper<User> {
     User findById(Long id);
}
