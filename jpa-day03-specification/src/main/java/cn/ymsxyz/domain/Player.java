//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.ymsxyz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "nick_name"
    )
    private String nickName;
    @Column(
            name = "grade"
    )
    private String grade;

    public Player() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String toString() {
        return "Player{id=" + this.id + ", nickName='" + this.nickName + '\'' + ", grade='" + this.grade + '\'' + '}';
    }
}
