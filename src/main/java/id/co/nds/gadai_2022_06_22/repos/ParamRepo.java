package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import id.co.nds.gadai_2022_06_22.entities.ParamEntity;

public interface ParamRepo extends JpaRepository<ParamEntity, String> {
    
}
