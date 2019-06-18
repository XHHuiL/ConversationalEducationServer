package com.fudan.dao;

import com.fudan.entity.UserConnectCourse;
import com.fudan.entity.UserConnectCourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserConnectCourseDao {
    long countByExample(UserConnectCourseExample example);

    int deleteByExample(UserConnectCourseExample example);

    int deleteByPrimaryKey(Integer id);

    Integer deleteByUserIdAndCourseId(UserConnectCourse record);

    int insert(UserConnectCourse record);

    int insertSelective(UserConnectCourse record);

    List<UserConnectCourse> selectByExample(UserConnectCourseExample example);

    UserConnectCourse selectByPrimaryKey(Integer id);

    UserConnectCourse selectByUserIdAndCourseId(UserConnectCourse record);

    int updateByExampleSelective(@Param("record") UserConnectCourse record, @Param("example") UserConnectCourseExample example);

    int updateByExample(@Param("record") UserConnectCourse record, @Param("example") UserConnectCourseExample example);

    int updateByPrimaryKeySelective(UserConnectCourse record);

    int updateByPrimaryKey(UserConnectCourse record);
}