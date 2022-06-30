package id.co.nds.gadai_2022_06_22.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;

@Repository
@Transactional
public interface CicilanTetapRepo extends JpaRepository<CicilanTetapEntity, String>, JpaSpecificationExecutor<CicilanTetapEntity>{
    @Query(value = "SELECT * FROM TX_TRANSAKSI_CICILAN_TETAP WHERE LOWER(no_transaksi) = LOWER(:no_transaksi)", nativeQuery = true)
    CicilanTetapEntity getCicilanTetapTransactionByNoTransaksi(@Param("no_transaksi") String noTransaksi);

    // @Query(value = "SELECT * FROM tx_transaksi_cicilan_tetap WHERE UPPER(no_transaksi) = UPPER(?1)", nativeQuery = true)
    // CicilanTetapEntity getCicilanTetapTransactionByNoTransaksi(String noTransaksi);
}
