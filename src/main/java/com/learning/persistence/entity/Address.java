package com.learning.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk;

    @NotEmpty
    private String address;

    private Boolean status;

    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotEmpty
    private Date create_at;

    @OneToOne
    @JoinColumn(name = "city",insertable = false,updatable = false)
    private City city;

    @ManyToOne()
    @JoinColumn(name = "user",insertable = false,updatable = false)
    private User user;
}
