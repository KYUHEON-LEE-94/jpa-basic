package org.example.helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.helloJpa.RoleType;
@Entity
public class Member extends  BaseEntity{
    @Id
    @GeneratedValue()
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;


    @ManyToOne //멤버입장에서는 Many to one
    @JoinColumn (name="TEAM_ID", insertable = false, updatable = false) //조인하는 컬럼(DB의 member의 team_id와 매핑하겠다)
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProduct = new ArrayList<>();

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
