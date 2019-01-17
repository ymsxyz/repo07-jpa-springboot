package cn.ymsxyz;

import cn.ymsxyz.dao.CustomerDao;
import cn.ymsxyz.dao.LinkManDao;
import cn.ymsxyz.domain.Customer;
import cn.ymsxyz.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class TestOne2Many {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testOne2Many() {
        Customer customer = new Customer();
        customer.setCusName("百度");

        LinkMan linkMan = new LinkMan();
        linkMan.setLinkName("小李");

        customer.getLinkmans().add(linkMan);
        linkMan.setCustomer(customer);
        //先保存一方,再多方,否则会有update语句?
        linkManDao.save(linkMan);
        customerDao.save(customer);

    }
}
