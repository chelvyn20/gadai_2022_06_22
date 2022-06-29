package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, String>, JpaSpecificationExecutor<CustomerEntity> {
    @Query(value = "SELECT COUNT (*) FROM ms_customer WHERE rec_status = '" + GlobalConstant.REC_STATUS_ACTIVE
            + "' AND LOWER(customer_name) = LOWER (:customer_name)", nativeQuery = true)
    long countByName(@Param("customer_name") String name);

    @Query(value = "SELECT COUNT (*) FROM ms_customer WHERE rec_status = '" + GlobalConstant.REC_STATUS_ACTIVE
            + "' AND customer_identity_no = (:customer_identity_no)", nativeQuery = true)
    long countByKtp(@Param("customer_identity_no") String callNumber);

    @Query(value = "SELECT COUNT (*) FROM ms_customer WHERE rec_status = '" + GlobalConstant.REC_STATUS_ACTIVE
            + "' AND customer_phone = :customer_phone", nativeQuery = true)
    long countByCallNumber(@Param("customer_phone") String callNumber);

}
