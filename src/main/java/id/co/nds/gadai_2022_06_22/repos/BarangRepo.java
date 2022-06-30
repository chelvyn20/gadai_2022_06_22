package id.co.nds.gadai_2022_06_22.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.BarangEntity;
import id.co.nds.gadai_2022_06_22.entities.compositeId.CompositeBarangId;

@Repository
@Transactional
public interface BarangRepo extends JpaRepository<BarangEntity,CompositeBarangId>{
    @Query(value = "SELECT * FROM tx_transaksi_barang  WHERE no_transaksi = :no_transaksi",nativeQuery = true)
    List<BarangEntity> findBarangByNoTrx(@Param("no_transaksi")String noTransaksi);

}
