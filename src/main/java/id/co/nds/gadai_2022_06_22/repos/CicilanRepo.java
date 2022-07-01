package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;

import id.co.nds.gadai_2022_06_22.entities.compositeId.CompositeCicilanId;

@Transactional
@Repository
public interface CicilanRepo extends JpaRepository<CicilanEntity,CompositeCicilanId>{
    
}
