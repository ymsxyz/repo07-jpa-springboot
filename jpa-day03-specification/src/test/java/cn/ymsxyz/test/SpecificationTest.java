package cn.ymsxyz.test;

import cn.ymsxyz.dao.PlayerDao;
import cn.ymsxyz.domain.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class SpecificationTest {

    @Autowired
    private PlayerDao playerDao;

    @Test
    public void testSpecification() {
        //使用匿名内部类的方式，创建一个Specification的实现类，并实现toPredicate方法
        Specification<Player> spec = new Specification<Player>() {
            public Predicate toPredicate(Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //cb:构建查询，添加查询方式   like：模糊匹配
                //root：从实体Customer对象中按照custName属性进行查询
                //and 多条件
                Path<Player> path = root.get("nickName");
                Predicate predicate1 = cb.like(path.as(String.class), "%雪%");

                Path<Object> path1 = root.get("id");
                Predicate predicate2 = cb.gt(path1.as(Long.class), 4L);
                Predicate and = cb.and(predicate1, predicate2);//like+gt

                return and;
            }
        };
        List<Player> playerList = playerDao.findAll(spec);
        System.out.println(playerList);
        System.out.println("============多条件查询===========");
        /**
         * 构造分页参数
         * 		Pageable : 接口
         * 			PageRequest实现了Pageable接口，调用构造方法的形式构造
         * 				第一个参数：页码（从0开始）
         * 				第二个参数：每页查询条数
         */
        Pageable pageable = new PageRequest(0, 2);
        Pageable pageable1 = new PageRequest(1, 2);

        /**
         * 分页查询，封装为Spring Data Jpa 内部的page bean
         * 		此重载的findAll方法为分页方法需要两个参数
         * 			第一个参数：查询条件Specification
         * 			第二个参数：分页参数
         */
        Page<Player> pages = playerDao.findAll(spec, pageable);
        Page<Player> pages1 = playerDao.findAll(spec, pageable1);

        System.out.println("pages:"+pages.getContent());
        System.out.println("pages1:"+pages1.getContent());
        System.out.println("============分页查询===========");
    }

}
