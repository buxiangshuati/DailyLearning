package com.qyy.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qyy.mp.domain.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Update("update tb_user set balance = balance - #{num} where id = #{id}")
    void deductPhoneById(Long id, Integer num);

//     void insert(User user);
}
