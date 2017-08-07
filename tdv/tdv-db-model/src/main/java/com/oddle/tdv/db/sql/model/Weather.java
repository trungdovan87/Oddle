package com.oddle.tdv.db.sql.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Weather implements Serializable {

    @Id
    @OneToOne
    private City city;

    private float windy;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public float getWindy() {
        return windy;
    }

    public void setWindy(float windy) {
        this.windy = windy;
    }
}
