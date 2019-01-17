package cn.ymsxyz.test;

import cn.ymsxyz.dao.PlayerDao;
import cn.ymsxyz.domain.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class SDJTest {

    @Autowired
    private PlayerDao playerDao;

    /**
     * 保存客户：调用save(obj)方法
     */
    @Test
    public void testSave() {
        Player player = new Player();
        player.setId(9L);
        player.setNickName("裂空斩");
        player.setGrade("1");
        playerDao.save(player);
    }

    /**
     * 修改客户：调用save(obj)方法
     * 对于save方法的解释：如果执行此方法是对象中存在id属性，即为更新操作会先根据id查询，再更新
     * 如果执行此方法中对象中不存在id属性，即为保存操作
     */
    @Test
//        @Transactional
//        @Rollback(false)
    public void testUpdate() {
        //根据id查询id为1的客户
        Player player = playerDao.findOne(1L);
        //修改客户名称
        player.setNickName("绽放刀锋");
        //更新
        playerDao.save(player);
    }

    /**
     * 根据id删除：调用delete(id)方法
     */
    @Test
    public void testDelete() {
        playerDao.delete(2L);
        playerDao.delete(3L);
    }

    /**
     * 根据id查询：调用findOne(id)方法
     */
    @Test
    public void testFindById() {
        System.out.println(playerDao.findOne(1L));
        System.out.println(playerDao.findOne(2L));
    }
}
