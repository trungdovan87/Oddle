package com.oddle.tdv.db.sql.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Embeddable
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "city")
    private List<LogWeather> logWeathers;

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

    public List<LogWeather> getLogWeathers() {
        return logWeathers;
    }

    public void setLogWeathers(List<LogWeather> logWeathers) {
        this.logWeathers = logWeathers;
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
