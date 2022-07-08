package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.PembayaranEntity;

@Repository
public interface PembayaranRepo extends JpaRepository<PembayaranEntity, String>{
    @Query(value = "SELECT * FROM TX_PEMBAYARAN_H WHERE UPPER(no_transaksi) = UPPER(:no_transaksi)", nativeQuery = true)
    PembayaranEntity getPembayaranDetailByNoTransaksi(@Param("no_transaksi") String noTransaksi);
}
