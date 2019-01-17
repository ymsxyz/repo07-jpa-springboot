package cn.ymsxyz;

import cn.ymsxyz.domain.User;
import cn.ymsxyz.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
//test类在基本包内classes = SpringbootMybatisApplication.class
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class SpringbootMybatisApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
        List<User> userList = userMapper.queryUserList();
        System.out.println(userList);
    }

}

