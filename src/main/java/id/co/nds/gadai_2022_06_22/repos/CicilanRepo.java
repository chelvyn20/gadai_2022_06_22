package id.co.nds.gadai_2022_06_22.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;


@Repository
public interface CicilanRepo extends JpaRepository<CicilanEntity,String>{
    
}
