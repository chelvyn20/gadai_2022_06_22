package id.co.nds.gadai_2022_06_22.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TX_DENDA_KETERLAMBATAN")
public class DendaKeterlambatanEntity {
    @Id
    @GenericGenerator(name = "denda_id_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.DendaIdGenerator")
    @GeneratedValue(generator = "denda_id_seq")
    @Column(name = "denda_id")
    private String dendaId;

    @Column(name = "no_transaksi")
    private String noTransaksi;

    @Column(name = "cicilan_ke")
    private Integer cicilanKe;

    @Column(name = "tgl_denda")
    private LocalDateTime tglDenda;

    @Column(name = "biaya_denda")
    private Double biayaDenda;

    @Column(name = "tgl_pembayaran_denda")
    private LocalDateTime tglPembayaranDenda;

    @Column(name = "no_pembayaran")
    private String noPembayaran;

    public String getDendaId() {
        return dendaId;
    }

    public void setDendaId(String dendaId) {
        this.dendaId = dendaId;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Integer getCicilanKe() {
        return cicilanKe;
    }

    public void setCicilanKe(Integer cicilanKe) {
        this.cicilanKe = cicilanKe;
    }

    public LocalDateTime getTglDenda() {
        return tglDenda;
    }

    public void setTglDenda(LocalDateTime tglDenda) {
        this.tglDenda = tglDenda;
    }

    public Double getBiayaDenda() {
        return biayaDenda;
    }

    public void setBiayaDenda(Double biayaDenda) {
        this.biayaDenda = biayaDenda;
    }

    public LocalDateTime getTglPembayaranDenda() {
        return tglPembayaranDenda;
    }

    public void setTglPembayaranDenda(LocalDateTime tglPembayaranDenda) {
        this.tglPembayaranDenda = tglPembayaranDenda;
    }

    public String getNoPembayaran() {
        return noPembayaran;
    }

    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

}
