package id.co.nds.gadai_2022_06_22.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.DendaKeterlambatanEntity;

@Repository
public interface DendaKeterlambatanRepo extends JpaRepository<DendaKeterlambatanEntity, String>, JpaSpecificationExecutor<DendaKeterlambatanEntity> {
    @Query(value = "SELECT * FROM TX_DENDA_KETERLAMBATAN WHERE UPPER(no_transaksi) = UPPER(':no_transaksi') AND cicilan_ke = :cicilan_ke", nativeQuery = true)
    List<DendaKeterlambatanEntity> findByNoTransaksiCicilanKe(@Param("no_transaksi") String noTransaksi, @Param("cicilan_ke") Integer cicilanKe);

    @Query(value = "SELECT COUNT(*) FROM TX_DENDA_KETERLAMBATAN WHERE UPPER(no_transaksi) = UPPER(':no_transaksi') AND cicilan_ke = :cicilan_ke", nativeQuery = true)
    Integer getCountDendaKeterlambatan(@Param("no_transaksi") String noTransaksi, @Param("cicilan_ke") Integer cicilanKe);
}
