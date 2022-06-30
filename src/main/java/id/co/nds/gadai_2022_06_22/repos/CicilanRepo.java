package id.co.nds.gadai_2022_06_22.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;

@Repository
@Transactional
public interface CicilanRepo extends JpaRepository<CicilanEntity, String>, JpaSpecificationExecutor<CicilanEntity> {
    
}
