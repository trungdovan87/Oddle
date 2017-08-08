package com.oddle.tdv.db.sql.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Embeddable
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "city")
    private Weather weather;

    @Basic(optional = false)
    @Column(unique = true, nullable = false, length = 50)
    private String name;

    @Column(nullable = true, length = 1000)
    private String note;

    public City() {
        this.setWeather(new Weather());
        this.getWeather().setCity(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
