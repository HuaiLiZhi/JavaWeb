package com.itheima;

import cn.hutool.core.io.FileUtil;
import com.example.HeaderConfig;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.pojo.Result;
import com.itheima.utils.AliyunOSSOperator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootTest
class SpringbootWebTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @Autowired
    private Gson gson;

    @Test
    public void testGson(){
        System.out.println(gson.toJson(Result.success("Hello Gson")));
    }


    @Test
    public void testScope(){
        for (int i = 0; i < 100; i++) {
            Object deptController = applicationContext.getBean("deptController");
            System.out.println(deptController);
        }
    }

    @Test
    public void testUpLoad() throws Exception {
        File file = new File("C:\\Users\\a1487\\Pictures\\Screenshots\\屏幕截图 2025-10-26 141545.png");
        String url = aliyunOSSOperator.upload(FileUtil.readBytes(file), "屏幕截图 2025-10-26 141545.png");
        System.out.println(url);
    }


//    @Autowired
//    private TokenParser tokenParser;
//
//    @Test
//    public void testTokenParser(){
//        tokenParser.parse();
//    }

    @Autowired
    private HeaderParser headerParser;

    @Test
    public void testHeaderParser(){
        headerParser.parse();
    }

}
