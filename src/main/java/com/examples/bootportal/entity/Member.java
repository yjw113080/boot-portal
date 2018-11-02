package com.examples.bootportal.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String email;
    private LocalDateTime regdate;

    @ManyToMany
    @JoinTable(name = "member_member_role",
                joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "member_role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public Member() {
        this.regdate = LocalDateTime.now();
    }

    public void addRole(Role role) {
        if (roles == null) {
            this.roles = new HashSet<>();
        }
        roles.add(role);
    }
}
