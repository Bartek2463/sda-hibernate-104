package com.sda.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name; // Andrzej
    @OneToOne
    @JoinColumn(name = "my_wife_id")
    Wife wife; // Martyna

    public Husband(String name) {
        this.name = name;
    }
}










