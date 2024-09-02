package xyz.kbws.service;

import xyz.kbws.model.User;

/**
 * @author kbws
 * @date 2024/9/2
 * @description:
 */
public interface UserService {

    User register(User user);

    String login(User user);

}
