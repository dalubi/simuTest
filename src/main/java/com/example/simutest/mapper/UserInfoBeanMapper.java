package com.example.simutest.mapper;


import com.example.simutest.pojo.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoBeanMapper {

    @Select("select * from user where username = #{username}")
    UserInfoBean selectByUsername(@Param("username") String username);

}
