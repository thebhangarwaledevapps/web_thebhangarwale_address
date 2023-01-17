package com.app.address.datasource.local;

import com.app.address.datasource.database.dao.AddressDao;
import com.app.address.datasource.database.dao.CustomerDao;
import com.app.address.entity.Address;
import com.app.address.entity.Customer;
import com.app.address.entity.LatLong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
class CustomerDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    AddressDao addressDao;

    @Test
    public void test_save_address() {
        List<Address> addressList = Arrays.asList(
                new Address("sai nagar 1","440034",new LatLong(1,1)),
                new Address("sai nagar 2","440035",new LatLong(1,1)),
                new Address("sai nagar 3","440036",new LatLong(1,1)),
                new Address("sai nagar 4","440037",new LatLong(1,1))
        );
        Customer customer = customerDao.save(new Customer("Bhangarwale_00001",addressList));


        List<Address> addressList1 = Arrays.asList(
                new Address("jai nagar 1","440038",new LatLong(2,2)),
                new Address("jai nagar 2","440039",new LatLong(2,2))
        );
        Customer customer2 = customerDao.save(new Customer("Bhangarwale_00003",addressList1));


    }


    /*@Test
    public void test_delete_address() {
        Customer customer = customerDao.findById("Bhangarwale_00001").get();
        List l = Arrays.asList(2L,6L);
        customer.getAddress().removeIf(address -> l.contains(address.getAddressId()));
        customerDao.save(customer);
    }*/



}