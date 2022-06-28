package id.co.nds.gadai_2022_06_22.models;

public class BarangModel {
    private String namaBarang;
    private String kondisi;
    private Integer jumlah;
    private Double hargaPerSatuan;
    
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
    public Integer getJumlah() {
        return jumlah;
    }
    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }
    public Double getHargaPerSatuan() {
        return hargaPerSatuan;
    }
    public void setHargaPerSatuan(Double hargaPerSatuan) {
        this.hargaPerSatuan = hargaPerSatuan;
    }
}
