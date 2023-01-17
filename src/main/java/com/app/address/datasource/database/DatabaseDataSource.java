package com.app.address.datasource.database;

import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DatabaseDataSource {
    Customer saveAddress(String customerId, String address, String pincode, double latitude, double longitude);

    Address updateAddress(Address address);

    Address findAddressByCustomerIdAndAddressId(String customerId, long addressId);

    Optional<Customer> findCustomerById(String customerId);

    Customer saveAddress(Customer customer);

    List<Address> getAllAddress(String customerId);

}
