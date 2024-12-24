package com.example.demo.entities;


import jakarta.persistence.Id;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Test")

public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="Nombre")
    private String first_name;
    @Column(name="last_name")
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="gender")
    private String gender;
    @Column(name="ip_address")
    private String ip_address;
    @Column(name="country")
    private String country;

    public Test() {
    }

    public Test(Long id, String first_name, String last_name, String email, String gender, String ip_address, String country) {
        Id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.ip_address = ip_address;
        this.country = country;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
