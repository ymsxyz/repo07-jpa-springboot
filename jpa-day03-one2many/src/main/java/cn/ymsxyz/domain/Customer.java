package cn.ymsxyz.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户的实体类
 * 明确使用的注解都是JPA规范的
 * 所以导包都要导入javax.persistence包下的
 */
@Entity//表示当前类是一个实体类
@Table(name="customer")//建立当前实体类和表之间的对应关系
public class Customer implements Serializable {

    @Id//表明当前私有属性是主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)//指定主键的生成策略
    @Column(name="cus_id")//指定和数据库表中的cust_id列对应
    private Long id;
    @Column(name="cus_name")//指定和数据库表中的cust_name列对应
   private  String cusName;
    //配置客户和联系人的一对多关系,放弃维权,参照对方(link_cuus_id)字段来生成,避免产生update语句
//    @OneToMany(targetEntity=LinkMan.class)
//    @JoinColumn(name="link_cus_id",referencedColumnName="cus_id")
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<LinkMan> linkmans = new HashSet<LinkMan>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Set<LinkMan> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(Set<LinkMan> linkmans) {
        this.linkmans = linkmans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cusName='" + cusName + '\'' +
                ", linkmans=" + linkmans +
                '}';
    }
}
