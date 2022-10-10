package com.learning.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Country {

    @Id
    private String pk;

    private String name;

    @OneToOne(mappedBy = "country")
    private City city;
}
