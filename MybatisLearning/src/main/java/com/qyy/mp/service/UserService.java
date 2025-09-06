package com.qyy.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qyy.mp.domain.po.User;

public interface UserService extends IService<User> {
    String deductPhoneById(Long id, Integer num);
}
