package com.qyy.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.qyy.mp.domain.dto.UserFormDto;
import com.qyy.mp.domain.po.User;
import com.qyy.mp.domain.vo.UserVo;
import com.qyy.mp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor // 通过这个注解可以实现构造器注入
@Tag(name = "用户模块")
public class UserController {

    private final UserService userService;

    @Operation(summary = "保存用户")
    @PostMapping
    public void saveUser(UserFormDto userDto) {
        User user = new User();
        BeanUtil.copyProperties(userDto, user);
        userService.save(user);
    }

    @Operation(summary = "根据ID删除用户")
    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.removeById(id);
    }

    @Operation(summary = "根据id 查询")
    @GetMapping("{id}")
    public UserVo getUserById(@PathVariable("id") Long id) {
        return BeanUtil.copyProperties(userService.getById(id), UserVo.class);
    }

    @Operation(summary = "根据ids 查询用户列表")
    @GetMapping
    public List<UserVo> listByIds(@RequestParam("ids") List<Long> ids) {
        // 获取所有用户
        List<User> users = userService.listByIds(ids);
        // 将 users 转换为 List<UserVo>
        return BeanUtil.copyToList(users, UserVo.class);
    }

    @Operation(summary = "根据id 来修改balance")
    @PutMapping("/{id}/deduct/{num}")
    public String deductPhoneById(@PathVariable("id") Long id, @PathVariable("num") Integer num) {
        String s = userService.deductPhoneById(id, num);
        return s;
    }
}
