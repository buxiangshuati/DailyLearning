package com.qyy.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qyy.mp.domain.po.User;
import com.qyy.mp.mapper.UserMapper;
import com.qyy.mp.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    // 实现自定义方法
    @Override
    @Transactional
    public String deductPhoneById(Long id, Integer num) {
        // 先查用户
//        getById(id);
        User user = baseMapper.selectById(id);

        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        // 假设电话号码是数字字符串，我们进行加减法操作
        Integer balance = user.getBalance();
        if (balance < num) {
            throw new RuntimeException("余额不足");
        }
        // 扣减余额
//        baseMapper.deductPhoneById(id, num);
        // 使用 lambdaUpdate 方法进行更新
        // 意思就是 如果扣减余额后小于0 就把状态改为2
        lambdaUpdate()
                .set(User::getBalance, balance - num)
                .set(balance - num == 0, User::getStatus, 2)// 假设扣减余额后状态变为0
                .eq(User::getId, id)
                .eq(User::getBalance, balance) // 乐观锁，确保余额未被其他事务修改
                .update();// 必须加上这个 update() 方法才能执行更新操作
        return "success";
    }
}
