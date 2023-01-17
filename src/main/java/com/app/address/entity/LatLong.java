package com.app.address.entity;

import javax.persistence.*;

@Entity
public class LatLong {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long latLongId;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    public LatLong() {
    }

    public LatLong(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getLatLongId() {
        return latLongId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
