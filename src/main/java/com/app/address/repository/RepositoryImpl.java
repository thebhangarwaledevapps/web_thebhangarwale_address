package com.app.address.repository;

import com.app.address.datasource.database.DatabaseDataSource;
import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.entity.LatLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class RepositoryImpl implements Repository {

    @Autowired
    private DatabaseDataSource databaseDataSourceImpl;

    @Override
    public Customer saveAddress(String customerId, String address, String pincode, double latitude, double longitude) {
        return Optional.ofNullable(getAllAddress(customerId))
                .flatMap(addresses -> databaseDataSourceImpl
                        .findCustomerById(customerId)
                        .map(customer -> {
                            customer.getAddress().add(new Address(address, pincode, new LatLong(latitude, longitude)));
                            return databaseDataSourceImpl.saveAddress(customer);
                        }))
                .orElseGet(() -> databaseDataSourceImpl.saveAddress(customerId, address, pincode, latitude, longitude));
    }

    @Override
    public Optional<Address> updateAddress(String customerId, long addressId, String address, String pincode, double latitude, double longitude) {
        return Optional.ofNullable(databaseDataSourceImpl.findAddressByCustomerIdAndAddressId(customerId, addressId))
                .map(addressObj -> {
                    addressObj.setAddress(address);
                    addressObj.setPincode(pincode);
                    addressObj.getLatLong().setLatitude(latitude);
                    addressObj.getLatLong().setLongitude(longitude);
                    return databaseDataSourceImpl.updateAddress(addressObj);
                });
    }

    @Override
    public Optional<List<Address>> deleteAddress(String customerId, List<Long> addressIds) {
        return databaseDataSourceImpl.findCustomerById(customerId)
                .map(customer -> {
                    customer.getAddress().removeIf(address -> addressIds.contains(address.getAddressId()));
                    databaseDataSourceImpl.saveAddress(customer);
                    return getAllAddress(customerId);
                });
    }

    @Override
    public List<Address> getAllAddress(String customerId) {
        final List<Address> addressList = databaseDataSourceImpl.getAllAddress(customerId);
        return addressList==null || addressList.isEmpty() ? null : addressList;
    }
}
