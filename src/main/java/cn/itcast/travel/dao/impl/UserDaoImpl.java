package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    //根据用户名查询用户信息
    @Override
    public User findByUsername(String username) {
        User user=null;
        try{
            //1.定义sql
            String sql="select * from tab_user where username = ?";
            //2.执行sql
            user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        }catch (Exception e){

        }

        return user;
    }
    //用户保存
    @Override
    public void save(User user) {
        //1.定义sql
        String sql="insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) value(?,?,?,?,?,?,?,?,?)";
        //2.执行sql
        template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),
                user.getSex(),user.getTelephone(),user.getEmail(),user.getStatus(),user.getCode());
    }

    @Override
    public User findByCode(String code) {
        User user=null;
        try {
            String sql = "select * from tab_user where code = ?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), code);
        }catch (Exception e){

        }
        return user;
    }

    @Override
    public void updataStatus(User user) {
        String sql="update tab_user set status = 'Y' where uid=?";
        template.update(sql,user.getUid());
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user=null;
        try{
            String sql="select * from tab_user where username =? && password =?";
            user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (Exception e){

        }
        return user;
    }

    @Override
    public boolean edit(User user) {
        String sql="update tab_user set username=?,password=?,name=?,birthday=?,sex=?,telephone=?,email=? where code=?";
        int update = template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),user.getSex(),user.getTelephone(),user.getEmail(),user.getCode());
        return update==1;
    }

}
