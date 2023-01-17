package com.app.address.datasource.database.dao;

import com.app.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddressDao extends JpaRepository<Address, Long> {

    @Query(value = "SELECT a.*,ll.* FROM " +
            "customer_address as ca left join address as a on ca.address_address_id = a.address_id " +
            "left join address_lat_long as adll on a.address_id = adll.address_id " +
            "left join lat_long as ll on adll.lat_long_id = ll.lat_long_id where ca.customer_customer_id = ?1 " +
            "and ca.address_address_id = ?2 and a.address_id = ?2", nativeQuery = true)
    Address findByCustomerIdAndAddressId(String customer_customer_id, long address_address_id);

    @Query(value = "SELECT a.*,ll.* FROM " +
            "customer_address as ca left join address as a on ca.address_address_id = a.address_id " +
            "left join address_lat_long as adll on a.address_id = adll.address_id " +
            "left join lat_long as ll on adll.lat_long_id = ll.lat_long_id where ca.customer_customer_id = ?1", nativeQuery = true)
    List<Address> findByCustomerId(String customer_customer_id);

}
