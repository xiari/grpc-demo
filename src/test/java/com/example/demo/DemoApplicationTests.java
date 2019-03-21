package com.example.demo;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.example.demo.mapper.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    Mapper mapper;
    @Test
    public void contextLoads() {

//        System.out.println(JSON.toJSON(mapper.query(1))) ;
        Map<String, Object> parms = new HashMap<>();
        parms.put("start",1);
        parms.put("offset",5);
//        parms.put("userId",2);

//        System.out.println(JSON.toJSON(mapper.queryUserInfo(parms)));
//        System.out.println(JSON.toJSON(mapper.query(3)));
        System.out.println(JSON.toJSON(mapper.queryOrder(1)));


    }

}
