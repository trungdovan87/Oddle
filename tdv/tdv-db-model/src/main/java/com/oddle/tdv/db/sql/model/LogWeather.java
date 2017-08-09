package com.oddle.tdv.db.sql.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cityId", nullable = false, foreignKey = @ForeignKey(name = "fk_logweather_city"))
    private City city;

    @Basic(optional = false)
    @Column(nullable = false)
    private float temperature;

    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String status;

    @Basic(optional = false)
    @Column(nullable = false)
    private float windy;

    @Basic(optional = false)
    @Column(nullable = false)
    private float humidity;

    @Basic(optional = false)
    @Column(nullable = false)
    private float pressure;

    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Basic(optional = true, fetch = FetchType.LAZY)
    @Column(nullable = true, length = 1000)
    private String note;

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

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @PrePersist
    private void prePersist() {
        if (createDate == null)
            createDate = new Date();
        if (status == null)
            status = "just created";
    }
}
