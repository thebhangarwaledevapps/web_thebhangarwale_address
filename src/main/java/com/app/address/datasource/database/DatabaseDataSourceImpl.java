package com.app.address.datasource.database;

import com.app.address.datasource.database.dao.AddressDao;
import com.app.address.datasource.database.dao.CustomerDao;
import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.entity.LatLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import static java.util.Arrays.asList;

@Service
public class DatabaseDataSourceImpl implements DatabaseDataSource {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    public Customer saveAddress(String customerId, String address, String pincode, double latitude, double longitude) {
        return customerDao.save(new Customer(customerId, asList(new Address(address, pincode, new LatLong(latitude, longitude)))));
    }

    @Override
    public Address updateAddress(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address findAddressByCustomerIdAndAddressId(String customerId, long addressId) {
        return addressDao.findByCustomerIdAndAddressId(customerId,addressId);
    }

    @Override
    public Optional<Customer> findCustomerById(String customerId) {
        return customerDao.findById(customerId);
    }

    @Override
    public Customer saveAddress(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public List<Address> getAllAddress(String customerId) {
        return addressDao.findByCustomerId(customerId);
    }
}
