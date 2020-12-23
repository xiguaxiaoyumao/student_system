package com.sunjob.mapper;

import com.sunjob.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zht
 * @date 2020/12/20 10:41
 */
@Repository
public interface UserMapper {
    /**
     * 登录
     *
     * @param user 用户名和密码
     * @return User 用户信息
     */
    @Select("select user_id, username, password, depart from user  where username = #{username} and password = #{password}")
    User login(User user);

    /**
     * 根据id查询
     *
     * @param user 用户id
     * @return User 用户信息
     */
    @Select("select user_id, username, password, depart from user  where user_id = #{user_id};")
    List<User> serlectByid(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return 影响条数
     */
    @Update("update user set username = #{username}, password = #{password}, depart=#{depart} where user_id = #{user_id};")
    int update(User user);

    /**
     * 删除用户
     *
     * @param user
     * @return 影响条数
     */
    @Delete("delete from user where user_id = #{user_id};")
    int delete(User user);

    /**
     * 添加用户
     *
     * @param user
     * @return 影响条数
     */
    @Insert("insert into user(user_id, username, password, depart) values(#{user_id},#{username},#{password},#{depart});")
    int insert(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select user_id, username, password, depart from user;")
    List<User> selectAllUsers();

    /**
     * 通过姓名模糊查询
     *
     * @return
     */
    @Select("select user_id, username, password, depart from user where username like concat('%',#{username},'%')")
    List<User> selectLikeUsername(User user);
}
