package com.app.address.repository;

import com.app.address.datasource.database.dao.AddressDao;
import com.app.address.datasource.database.dao.CustomerDao;
import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.result.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RepositoryImplTest {

    @Autowired
    RepositoryImpl repositoryImpl;



    @Test
    void test_updateAddress() {
        Customer customer = repositoryImpl.saveAddress(
                "Bhangarwale_00001",
                "sai nagar 1",
                "440034",
                12.23,
                13.23
        );
        System.out.println(customer);

        Customer customer2 = repositoryImpl.saveAddress(
                "Bhangarwale_00001",
                "sai nagar 2",
                "440035",
                12.23,
                13.23
        );
        System.out.println(customer2);

        //addressDao.deleteAll();
        //Result<List<Address>> result = repositoryImpl.getAllAddress("Bhangarwale_00001");
        //System.out.println(result);
    }



}