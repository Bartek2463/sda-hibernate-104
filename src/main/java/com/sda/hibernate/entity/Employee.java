package com.sda.hibernate.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")
@NoArgsConstructor
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    String name;
    @Column(name = "password")
    String secret;
    @Column(length = 9,unique = true)
    String telephoneNumber;
    @Transient
    long age;
    @Temporal(TemporalType.DATE)
    Date birthDate;
    @Enumerated(EnumType.STRING) // typ wyliczeniowy Enum
    Gender gender;
    @Lob
    String description;
    @Embedded
    Address address;

    public enum Gender {
        FEMALE, MALE
    }

    public Employee(String name, String secret, String telephoneNumber, long age, Date birthDate, Gender gender, String description) {
        this.name = name;
        this.secret = secret;
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
        this.description = description;
    }
}

