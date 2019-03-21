package com.example.demo.mapper;

import com.example.demo.entity.So;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Mapper {

   List<Teacher> query(int id);

   List<Teacher> queryUserInfo(Map<String, Object> paraMap);

   List<Student> selectAddressForUser (int id);

   List<So> queryOrder(@Param(value= "id") int id);

}
