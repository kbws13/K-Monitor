package xyz.kbws.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.kbws.model.User;
import xyz.kbws.service.UserService;

/**
 * @author kbws
 * @date 2024/9/2
 * @description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User register(User user) {
        log.info("开始注册 {}", user.getAccount());
        log.info("注册成功 {}", user.getAccount());
        return user;
    }

    @Override
    public String login(User user) {
        log.info("开始登录 {}", user);
        log.info("登录成功 {}", user);
        return "登录成功";
    }
}
