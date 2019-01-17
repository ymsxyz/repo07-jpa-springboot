package cn.ymsxyz.quick;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//注意:成员变量必须有set方法
@ConfigurationProperties(prefix = "student")
public class QuickApplicationTests {

   // @Value("${student.name}")
    private String name;
   // @Value("${student.age}")
    private Integer age;

    @Test
    public void testConfigurationGet() {
        System.out.println("name:" + name + ",age:" + age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

