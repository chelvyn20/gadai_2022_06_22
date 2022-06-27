package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.UserEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity>{
    @Query(value = "SELECT COUNT(*) FROM ms_user WHERE rec_status = '" + 
    GlobalConstant.REC_STATUS_ACTIVE + "' AND LOWER(user_id) = LOWER(:user_id)", nativeQuery = true)
    long countByUserId(@Param("user_id") String userId);

    @Query(value = "SELECT COUNT(*) FROM ms_user WHERE rec_status = '" + 
    GlobalConstant.REC_STATUS_ACTIVE + "' AND user_no_hp = :user_no_hp", nativeQuery = true)
    long countByPhoneNumber(@Param("user_no_hp") String phoneNumber);
}
