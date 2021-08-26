package top.sakuraffy.service;

import top.sakuraffy.data.annotation.User;

/**
 * @author: zhangqiushi
 * @create: 2021/08/02 18:43
 */
public interface UserService {
    User getById();

    User getByName(String name);
}
