package com.learning.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @NotEmpty
    private String name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    private String gender;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    private Boolean status;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotEmpty
    private Date create_at;

    @ManyToOne
    @JoinColumn(name = "role",insertable = false,updatable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Address> addresses;

    @OneToOne(mappedBy = "user")
    private Information information;

    @OneToMany(mappedBy = "grupo")
    private List<Request> requests;

    @OneToMany(mappedBy = "user")
    private List<Group> groups;

    @OneToMany(mappedBy = "user")
    private List<Menber> menbers;

    @OneToMany(mappedBy = "user")
    private List<Chaea> chaeas;


}
