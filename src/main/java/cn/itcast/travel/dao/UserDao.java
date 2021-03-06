package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    public User findByUsername(String username);
    public  void save(User user);

    User findByCode(String code);

    void updataStatus(User user);

    User findByUsernameAndPassword(String username, String password);

    boolean edit(User user);
}
