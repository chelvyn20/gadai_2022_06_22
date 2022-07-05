package id.co.nds.gadai_2022_06_22.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;

@Repository
@Transactional
public interface CicilanRepo extends JpaRepository<CicilanEntity, String>, JpaSpecificationExecutor<CicilanEntity> {
    @Query(value = "SELECT * FROM TX_CICILAN WHERE no_transaksi = :no_transaksi AND UPPER(tx_status) = UPPER('AKTIF') OR no_transaksi = :no_transaksi AND UPPER(tx_status) = UPPER('TERLAMBAT')", nativeQuery = true)
    List<CicilanEntity> getPembayaranCicTetap(@Param("no_transaksi") String noTransaksi);

}
