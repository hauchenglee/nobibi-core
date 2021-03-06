package com.nobibi.nobibicore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    // TODO: change entity id to pk, then change account to id
    @Id
    private String user_id;

    @Column(nullable = false, unique = true)
    @NotNull
    private String user_account;

    @Column(nullable = false)
    @NotNull
    private String user_password;

    @Column(nullable = false)
    @NotNull
    private String user_name;

    @Column(nullable = false, unique = true)
    @NotNull
    @Email
    private String user_email;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "user_dept",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "dept_id")})
    private List<Dept> deptList;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roleList;
}
