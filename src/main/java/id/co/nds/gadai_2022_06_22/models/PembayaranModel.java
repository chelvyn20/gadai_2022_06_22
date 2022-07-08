package id.co.nds.gadai_2022_06_22.models;

public class PembayaranModel {
    private String noPembayaran;
    private String noTransaksi;
    private Double totalTagihanCicilan;
    private Double totalTagihanDenda;
    private Double biayaAdmTutup;
    private Double totalTagihan;
    private Double pembulatan;
    private Double jumlahPembayaran;
    private String metodeBayar;
    
    public String getNoPembayaran() {
        return noPembayaran;
    }
    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public Double getTotalTagihanCicilan() {
        return totalTagihanCicilan;
    }
    public void setTotalTagihanCicilan(Double totalTagihanCicilan) {
        this.totalTagihanCicilan = totalTagihanCicilan;
    }
    public Double getTotalTagihanDenda() {
        return totalTagihanDenda;
    }
    public void setTotalTagihanDenda(Double totalTagihanDenda) {
        this.totalTagihanDenda = totalTagihanDenda;
    }
    public Double getBiayaAdmTutup() {
        return biayaAdmTutup;
    }
    public void setBiayaAdmTutup(Double biayaAdmTutup) {
        this.biayaAdmTutup = biayaAdmTutup;
    }
    public Double getTotalTagihan() {
        return totalTagihan;
    }
    public void setTotalTagihan(Double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }
    public Double getPembulatan() {
        return pembulatan;
    }
    public void setPembulatan(Double pembulatan) {
        this.pembulatan = pembulatan;
    }
    public Double getJumlahPembayaran() {
        return jumlahPembayaran;
    }
    public void setJumlahPembayaran(Double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }
    public String getMetodeBayar() {
        return metodeBayar;
    }
    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }
   
}
