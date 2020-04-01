package com.swjtu.zjz.service.impl;

import org.springframework.ui.Model;

public interface signinServiceImpl {
    String signin(String username, String password, String role, Model model);
}
