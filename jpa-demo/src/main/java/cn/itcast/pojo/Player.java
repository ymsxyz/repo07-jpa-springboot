package cn.itcast.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "player")
@Data
@NoArgsConstructor
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//AUTO/TABLE
    @Column(name = "id")
    private Integer id;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "grade")
    private String grade;
}
