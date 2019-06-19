package com.fudan.dao;

import com.fudan.entity.Option;
import com.fudan.entity.OptionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
@Mapper
public interface OptionDao {
    long countByExample(OptionExample example);

    int deleteByExample(OptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Option record);

    int insertSelective(Option record);

    List<Option> selectByExample(OptionExample example);

    Option selectByPrimaryKey(Integer id);

    List<Option> selectByContentId(Integer id);

    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}