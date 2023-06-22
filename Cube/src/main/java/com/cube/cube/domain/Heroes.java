package com.cube.cube.domain;

import jakarta.persistence.*;

@Entity
public class Heroes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "pass_word")
    private double passWord;
    @Basic
    @Column(name = "phone_number")
    private int phoneNumber;
    @Basic
    @Column(name = "Accidenttype1")
    private int accidenttype1;
    @Basic
    @Column(name = "Accidenttype2")
    private Integer accidenttype2;
    @Basic
    @Column(name = "Accidenttype3")
    private Integer accidenttype3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPassWord() {
        return passWord;
    }

    public void setPassWord(double passWord) {
        this.passWord = passWord;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAccidenttype1() {
        return accidenttype1;
    }

    public void setAccidenttype1(int accidenttype1) {
        this.accidenttype1 = accidenttype1;
    }

    public Integer getAccidenttype2() {
        return accidenttype2;
    }

    public void setAccidenttype2(Integer accidenttype2) {
        this.accidenttype2 = accidenttype2;
    }

    public Integer getAccidenttype3() {
        return accidenttype3;
    }

    public void setAccidenttype3(Integer accidenttype3) {
        this.accidenttype3 = accidenttype3;
    }

}
