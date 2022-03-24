package com.sda.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // jezeli używamy adnotacjii
@Table(name = "dog") // taka nazwa jak w bazie danych "dog"
@NoArgsConstructor //konstruktor bez parametrowy
@Data // gettery settery string
public class Dog {

    @Id  // autoinkremetacja
    @GeneratedValue(strategy = GenerationType.IDENTITY) //specjalny typ kolumny.

    private Long id;
    private String name;
    private Integer age;
    private String race;
    @Column(length = 3,unique = true)//columna z rozmiarem 3 i wartosci unikalne
    private String dna;

    public Dog(String name, Integer age, String race,String dna) {
        this.name = name;
        this.age = age;
        this.race = race;
        this.dna = dna;
    }
}
