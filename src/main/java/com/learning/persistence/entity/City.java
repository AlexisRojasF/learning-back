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
public class City {
    @Id
    private Long pk;

    @OneToOne
    @JoinColumn(name = "country",insertable = false,updatable = false)
    private Country country;

    @OneToOne(mappedBy = "city")
    private Address address;
}
