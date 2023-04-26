package org.example.helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.example.helloJpa.RoleType;
@Entity
// @SequenceGenerator(name = "memeber_seq_generator", sequenceName = "member_seq")
@TableGenerator(name = "memeber_seq_generator", table = "MY_SEQUENCES", pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO) //DB 방언에 맞춰서 자동 생성
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 생성을 데이터베이스에 위임
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) //자동 증가~ LONG 타입 사용
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "memeber_seq_generator")
    private Long id;
    @Column(name = "name")
    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
