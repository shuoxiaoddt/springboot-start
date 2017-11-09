package com.uway.springboot.boot.mapper;

import com.uway.springboot.boot.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by uwayxs on 2017/11/9.
 */
@Mapper
public interface UserInfoMapper {

    @Select("select * from UserInfo user where user.username = #{username}")
    UserInfo findByUsername(String username);

}
