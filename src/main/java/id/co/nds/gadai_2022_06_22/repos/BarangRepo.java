package id.co.nds.gadai_2022_06_22.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.embedded.TransactionId;
import id.co.nds.gadai_2022_06_22.entities.BarangEntity;

@Repository
public interface BarangRepo extends JpaRepository<BarangEntity, TransactionId>, JpaSpecificationExecutor<BarangEntity> {
    @Query(value = "SELECT * FROM TX_TRANSAKSI_BARANG WHERE no_transaksi = :no_transaksi", nativeQuery = true)
    List<BarangEntity> findByNoTransaksi(@Param("no_transaksi") String noTransaksi);
}
