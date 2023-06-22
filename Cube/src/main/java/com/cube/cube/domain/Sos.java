package com.cube.cube.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Long id;
    @Basic
    @Column(name = "Place")
    private String place;
    @Basic
    @Column(name = "AccidenttypeID")
    private int accidenttype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAccidenttype() {
        return accidenttype;
    }

    public void setAccidenttype(int accidenttype) {
        this.accidenttype = accidenttype;
    }


    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
