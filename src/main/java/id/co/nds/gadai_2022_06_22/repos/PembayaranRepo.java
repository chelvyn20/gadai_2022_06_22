package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.PembayaranEntity;

@Repository
public interface PembayaranRepo extends JpaRepository<PembayaranEntity, String>{
    
}
