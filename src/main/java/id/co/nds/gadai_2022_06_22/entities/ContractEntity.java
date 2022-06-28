package id.co.nds.gadai_2022_06_22.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tx_transaksi_cicilan_tetap")
public class ContractEntity {
    @Column(name="total_nilai_taksiran")
    private Double totalNilaiTaksiran;

    @Column(name="nilai_pencairan_pelanggan")
    private Double nilaiPencairanPelanggan;

    @Column(name="diskon_adm_buka")
    private Double diskonAmdBuka;
}
