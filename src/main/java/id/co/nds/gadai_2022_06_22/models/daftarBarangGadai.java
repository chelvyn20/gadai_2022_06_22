package id.co.nds.gadai_2022_06_22.models;

public class daftarBarangGadai {
    private Integer noUrut;
    private String noTransaksi;
    private String namaBarang;
    private String kondisi;
    private Integer jumlahBarang;
    private Double hargaPerSatuan;
    
    public Integer getNoUrut() {
        return noUrut;
    }
    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public String getKondisi() {
        return kondisi;
    }
    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }
    public Integer getJumlahBarang() {
        return jumlahBarang;
    }
    public void setJumlahBarang(Integer jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    public Double getHargaPerSatuan() {
        return hargaPerSatuan;
    }
    public void setHargaPerSatuan(Double hargaPerSatuan) {
        this.hargaPerSatuan = hargaPerSatuan;
    }
    
}
