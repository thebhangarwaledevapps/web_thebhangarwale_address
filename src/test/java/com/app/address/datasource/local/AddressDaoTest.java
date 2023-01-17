package com.app.address.datasource.local;

import com.app.address.datasource.database.dao.AddressDao;
import com.app.address.datasource.database.dao.CustomerDao;
import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.entity.LatLong;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.provider.PersistenceProvider;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AddressDaoTest {

    @Autowired
    AddressDao addressDao;

    @Autowired
    CustomerDao customerDao;

    @Test
    public void test_find_address() {
        try {
            List<Address> address =  addressDao.findByCustomerId("Bhangarwale_00001");
            System.out.println(address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //PersistenceProvider
        }

    }

}