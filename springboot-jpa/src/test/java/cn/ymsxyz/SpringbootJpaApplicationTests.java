package cn.ymsxyz;

import cn.ymsxyz.domain.User;
import cn.ymsxyz.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * jpa测试
     */
    @Test
    public void testSpringbootJpa() {
        System.out.println(userRepository.findAll());
    }

    /**
     * redis测试
     * 缓存中获取,如果为null,则数据库获取,存入缓存
     */
    @Test
    public void testSpringbootRedis() {
        List<User> userList = (List<User>) redisTemplate.boundValueOps("findAll").get();
        if (userList == null) {
            userList = userRepository.findAll();
            System.out.println("===从mysql中读取");
            redisTemplate.boundValueOps("findAll").set(userList);
        } else {
            System.out.println("===从redis中读取");
        }
        System.out.println(userList);
    }
}

