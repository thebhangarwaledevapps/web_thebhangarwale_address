package com.app.address.datasource.database.dao;

import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, String> {

}
