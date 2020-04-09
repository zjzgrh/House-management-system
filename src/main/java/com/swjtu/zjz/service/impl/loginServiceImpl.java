package com.swjtu.zjz.service.impl;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface loginServiceImpl {

    String login(String phonenum, String password, String role, HttpSession session, Model model);
}
