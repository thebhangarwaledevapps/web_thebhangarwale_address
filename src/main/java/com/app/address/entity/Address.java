package com.app.address.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String pincode;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinTable(name = "address_lat_long",
            joinColumns = {
                    @JoinColumn(name = "address_id", referencedColumnName = "addressId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "lat_long_id", referencedColumnName = "latLongId")
            }
    )
    private LatLong latLong;

    public Address() {
    }

    public Address(String address, String pincode, LatLong latLong) {
        this.address = address;
        this.pincode = pincode;
        this.latLong = latLong;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public LatLong getLatLong() {
        return latLong;
    }

    public void setLatLong(LatLong latLong) {
        this.latLong = latLong;
    }

}
