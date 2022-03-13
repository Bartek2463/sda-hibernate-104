package com.sda.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Wife {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name; // Martyna
    @OneToOne(mappedBy = "wife")
    Husband husband; // Andrzej

    public Wife(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
        this.husband.setWife(this);
    }
}











