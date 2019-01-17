package cn.itcast.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 静态生成实体管理器工厂
 * 创建生成实体管理器静态方法
 */
public class JpaUtil {
    private  static EntityManagerFactory factory;
    static{
         factory = Persistence.createEntityManagerFactory("myJpa");
    }

    public static EntityManager getEntityManager() {
        System.out.println(factory);
        return factory.createEntityManager();
    }
}
