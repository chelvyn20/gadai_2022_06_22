package id.co.nds.gadai_2022_06_22.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity,String>, JpaSpecificationExecutor<CustomerEntity>{
    @Query(value = "SELECT COUNT (*) FROM ms_customer WHERE cust_status = '"  + GlobalConstant.REC_STATUS_ACTIVE
    + "' AND LOWER(name) = LOWER (:name)",nativeQuery = true)
    long countByName(@Param("name")String name);

    @Query (value="SELECT COUNT (*) FROM ms_customer WHERE cust_status = '" + GlobalConstant.REC_STATUS_ACTIVE
    + "' AND cust_ktp = (:cust_ktp)",nativeQuery =  true)
    long countByKtp(@Param("cust_ktp") String callNumber);

    @Query (value="SELECT COUNT (*) FROM ms_customer WHERE cust_status = '" + GlobalConstant.REC_STATUS_ACTIVE
    + "' AND cust_hp = :cust_hp" , nativeQuery =  true)
    long countByCallNumber(@Param("cust_hp") String callNumber);

    
}

