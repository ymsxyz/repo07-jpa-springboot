package cn.ymsxyz.domain;

import javax.persistence.*;

@Entity
@Table(name = "linkman")
public class LinkMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "link_id")
    private Long id;
    @Column(name = "link_name")
    private String linkName;
//    @Column(name = "link_cus_id")
//    private Long cusId;

    /**
     * 联系人的实体类（数据模型）
     */

    //多对一关系映射：多个联系人对应客户
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "link_cus_id", referencedColumnName = "cus_id")
    private Customer customer;//用它的主键，对应联系人表中的外键

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "id=" + id +
                ", linkName='" + linkName + '\'' +
                ", customer=" + customer +
                '}';
    }
}
