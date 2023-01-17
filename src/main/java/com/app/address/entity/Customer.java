package com.app.address.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Column(nullable = false)
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Address> address;

    public Customer() {
    }

    public Customer(String customerId, List<Address> address) {
        this.customerId = customerId;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}
