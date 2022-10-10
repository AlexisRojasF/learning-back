package com.learning.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @NotEmpty
    private String name;

    private Boolean status;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_at;

    @OneToMany(mappedBy = "group")
    private List<Period> periods;

    @OneToMany(mappedBy = "group")
    private List<Request> requests;

    @OneToMany(mappedBy = "grupo")
    private List<Menber> menbers;

    @ManyToOne
    @JoinColumn(name = "user_create",insertable = false,updatable = false)
    private User user;
}
