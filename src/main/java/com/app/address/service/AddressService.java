package com.app.address.service;

import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.exception.InvalidAddressException;
import com.app.address.exception.InvalidLatLongException;
import com.app.address.exception.InvalidPincodeException;
import com.app.address.repository.Repository;
import com.app.address.result.ClientError;
import com.app.address.result.Result;
import com.app.address.result.ServerError;
import com.app.address.result.Success;
import com.app.address.util.internalization.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AddressService {

    @Autowired
    private Repository repositoryImpl;

    @Autowired
    private Translator translator;

    public Result saveAddress(String customerId, String address, String pincode, double latitude, double longitude) {
        Result result = null;
        try {
            validateAddress(address, pincode, latitude, longitude);
            result = Optional.ofNullable(repositoryImpl.saveAddress(customerId, address, pincode, latitude, longitude))
                    .map((Function<Customer, Result<String>>) customer -> new Success(translate("success_address_save")))
                    .orElse(new ServerError(new Exception(translate("error_something_went_wrong"))));
        } catch (InvalidAddressException | InvalidPincodeException | InvalidLatLongException ex) {
            result = new ClientError(ex);
        }
        return result;
    }

    public Result updateAddress(String customerId, long addressId, String address, String pincode, double latitude, double longitude) {
        Result result = null;
        try {
            validateAddress(address, pincode, latitude, longitude);
            result = repositoryImpl.updateAddress(customerId, addressId, address, pincode, latitude, longitude)
                        .map((Function<Address, Result<String>>) address1 -> new Success(translate("success_address_update")))
                        .orElse(new ServerError(new Exception(translate("error_something_went_wrong"))));
        } catch (InvalidAddressException | InvalidPincodeException | InvalidLatLongException ex) {
            result = new ClientError(ex);
        }
        return result;
    }

    public Result deleteAddress(String customerId, List<Long> addressIds) {
        return repositoryImpl.deleteAddress(customerId, addressIds)
                .map((Function<List<Address>, Result<List<Address>>>) Success::new)
                .orElse(new ServerError(new Exception(translate("error_no_address_found"))));
    }

    public Result getAllAddress(String customerId) {
        return Optional.ofNullable(repositoryImpl.getAllAddress(customerId))
                .map((Function<List<Address>, Result<List<Address>>>) Success::new)
                .orElse(new ServerError(new Exception(translate("error_no_address_found"))));
    }

    private void validateAddress(String address, String pincode, double latitude, double longitude)
            throws InvalidAddressException, InvalidPincodeException, InvalidLatLongException {
        if (address == null || address.isEmpty()) {
            throw new InvalidAddressException(translate("error_valid_address"));
        }
        if (pincode == null || pincode.length() != 6) {
            throw new InvalidPincodeException(translate("error_valid_pincode"));
        }
        if (!(latitude > 0 && longitude > 0)) {
            throw new InvalidLatLongException(translate("error_valid_location"));
        }
    }

    private String translate(String msg) {
        return translator.toLocale(msg);
    }

}
