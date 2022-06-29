package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;

public interface CicilanTetapRepo extends JpaRepository<CicilanTetapEntity,String>, JpaSpecificationExecutor<CicilanTetapEntity>{
    
}
