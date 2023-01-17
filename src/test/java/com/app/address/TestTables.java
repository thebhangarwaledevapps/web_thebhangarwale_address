package com.app.address;

import com.app.address.datasource.database.dao.AddressDao;
import com.app.address.datasource.database.dao.CustomerDao;
import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class TestTables {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    AddressDao addressDao;

    @Test
    void test(){
        customerDao.save(new Customer("Bhangarwale_00001",Arrays.asList(new Address("Sai Nagar","440034",null))));
    }

}
