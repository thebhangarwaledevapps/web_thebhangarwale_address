package com.app.address.controller;

import com.app.address.result.ClientError;
import com.app.address.result.Result;
import com.app.address.result.ServerError;
import com.app.address.result.Success;
import com.app.address.service.AddressService;
import com.app.address.util.internalization.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/saveAddress")
    public ResponseEntity saveAddress(
            @RequestParam String customerId,
            @RequestParam String address,
            @RequestParam String pincode,
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        return getResultResponseEntity(addressService.saveAddress(customerId, address, pincode, latitude, longitude));
    }

    @GetMapping("/updateAddress")
    public ResponseEntity updateAddress(
            @RequestParam String customerId,
            @RequestParam long addressId,
            @RequestParam String address,
            @RequestParam String pincode,
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        return getResultResponseEntity(addressService.updateAddress(customerId, addressId, address, pincode, latitude, longitude));
    }

    @PostMapping("/deleteAddress")
    public ResponseEntity deleteAddress(
            @RequestParam String customerId,
            @RequestBody List<Long> addressId
    ) {
        return getResultResponseEntity(addressService.deleteAddress(customerId, addressId));
    }

    @GetMapping("/getAllAddress")
    public ResponseEntity getAllAddress(
            @RequestParam String customerId
    ) {
        return getResultResponseEntity(addressService.getAllAddress(customerId));
    }

    private ResponseEntity getResultResponseEntity(Result result) {
        ResponseEntity responseEntity = null;
        if (result instanceof Success) {
            Success success = (Success) result;
            responseEntity = ResponseEntity.ok(success.getData());
        } else if (result instanceof ClientError) {
            ClientError clientError = (ClientError) result;
            responseEntity = ResponseEntity.badRequest().body(clientError.getException().getMessage());
        } else if (result instanceof ServerError) {
            ServerError serverError = (ServerError) result;
            responseEntity = ResponseEntity.internalServerError().body(serverError.getException().getMessage());
        }
        return responseEntity;
    }


}
