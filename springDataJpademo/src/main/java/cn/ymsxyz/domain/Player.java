package cn.ymsxyz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {
   @Id
   @Column(name = "id")
   private Long id;
   @Column(name = "nick_name")
   private String nickName;
   @Column(name = "grade")
   private String grade;

   public Player() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getNickName() {
      return nickName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }

   public String getGrade() {
      return grade;
   }

   public void setGrade(String grade) {
      this.grade = grade;
   }

   @Override
   public String toString() {
      return "Player{" +
              "id=" + id +
              ", nickName='" + nickName + '\'' +
              ", grade='" + grade + '\'' +
              '}';
   }
}
