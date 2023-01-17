package com.app.address.repository;

import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.result.Result;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Repository {

    Customer saveAddress(String customerId, String address, String pincode, double latitude, double longitude);

    Optional<Address> updateAddress(String customerId, long addressId, String address, String pincode, double latitude, double longitude);

    Optional<List<Address>> deleteAddress(String customerId, List<Long> addressIds);

    List<Address> getAllAddress(String customerId);

}
