package com.example.testmongo.dao;


import com.example.testmongo.entity.Bug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BugDao {

    @Select("SELECT * FROM chk_res_bug_1559")
    List<Bug> findAll();

}
