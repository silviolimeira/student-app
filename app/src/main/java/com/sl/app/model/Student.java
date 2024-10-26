package com.sl.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int age;
    @Column(name = "zip_code")
    private int zipCode;
    private String country;
    private Status status;

    public Student() {
    }

    public Student(String name, int age, int zipCode, String country, Status status) {
        this.name = name;
        this.age = age;
        this.zipCode = zipCode;
        this.country = country;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
