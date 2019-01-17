package cn.itcast.test;

import cn.itcast.pojo.Player;
import cn.itcast.util.JpaUtil;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class JPATest {

    //增
    @Test
    public void testJpaOriginal() {
        //创建实体管理工厂
        //EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //创建实体管理器:1.过去事务管理器;2.执行操作
        //EntityManager em = factory.createEntityManager();

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();//开启事务
        Player player = new Player();
        player.setNickName("崔雪");
        player.setGrade("11");
        em.persist(player);
        trans.commit();//提交事务
        em.close();
    }

    //查
    @Test
    public void testQuery() {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();//开启事务
        //em.find(Player.class,1);//立即
        Player player = em.getReference(Player.class, 1);//延迟
        System.out.println(player);
        trans.commit();//提交事务
        em.close();
    }

    //删
    @Test
    public void testRemove() {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();//开启事务
        Player player1 = em.getReference(Player.class, 1);
        em.remove(player1);
        trans.commit();//提交事务
        em.close();
    }

    //改
    @Test
    public void testUpdate() {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction trans = em.getTransaction();

        trans.begin();//开启事务
        Player player = new Player();
        player.setId(1);
        player.setNickName("ymsxyz");
        em.merge(player);
        trans.commit();//提交事务
        em.close();
    }
    
    //jpql
    @Test
    public void testJpql(){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();
        tran.begin();

        //查询全部
//        String jpql="from Player";
//        Query query = em.createQuery(jpql);
        //分页查询
//        query.setFirstResult(0);//起始索引,从1开始
//        query.setMaxResults(4);//条数
//        List playerList = query.getResultList();//前四条记录
//        System.out.println(playerList);

        //排序查询
//        String jpql="from Player order by id desc";
//        Query query = em.createQuery(jpql);
//        List playerList = query.getResultList();
//        System.out.println(playerList);
        //统计查询
//        String jpql="select count(id) from Player";
//        Query query = em.createQuery(jpql);
//        Long count = (Long) query.getSingleResult();
//        System.out.println(count);
        //条件查询
        String jpql="from Player where nickName like ? and id>?";
        Query query = em.createQuery(jpql);
        query.setParameter(1,"%雪%");
        query.setParameter(2,4);
        System.out.println(query.getResultList());
        tran.commit();
        em.close();
    }
}
