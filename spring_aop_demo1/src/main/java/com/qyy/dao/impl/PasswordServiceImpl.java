package com.qyy.dao.impl;

import com.qyy.dao.PasswordService;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public boolean readResource(String password) {
        return password.equals("mypassword");
    }
}
