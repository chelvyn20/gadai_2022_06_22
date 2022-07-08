package id.co.nds.gadai_2022_06_22.models;

import java.util.List;

public class CustomerPaymentModel {
    private String noTransaksi;
    private String metodeBayar;
    private Double jumlahPembayaran;
    private List<Integer> selectedCicilanKe;
    
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public String getMetodeBayar() {
        return metodeBayar;
    }
    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }
    public Double getJumlahPembayaran() {
        return jumlahPembayaran;
    }
    public void setJumlahPembayaran(Double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }
    public List<Integer> getSelectedCicilanKe() {
        return selectedCicilanKe;
    }
    public void setSelectedCicilanKe(List<Integer> selectedCicilanKe) {
        this.selectedCicilanKe = selectedCicilanKe;
    }
}
