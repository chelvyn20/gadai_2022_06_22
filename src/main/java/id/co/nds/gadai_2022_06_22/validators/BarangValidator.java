package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

public class BarangValidator {
    public void nullChekcNoBarang(Integer noBrg) throws ClientException{
        if(noBrg==null){
            throw new ClientException( "Nomor barang tidak boleh kosong");

        }
    }
    
    public void notnullChekcNoBarang(Integer noBrg ) throws ClientException {
        if(noBrg!=null){
            throw new ClientException( "Nomor barang dibuat secara otomatis, jangan masukkan!");

        }
    }

    public void nullCheckBarangName(String barangName) throws ClientException {
        if(barangName == null) {
            throw new ClientException("Nama barang tidak boleh kosong");
        }
    }

    public void nullCheckBarangDesc(String desk) throws ClientException {
        if(desk == null) {
            throw new ClientException("Deskripsi barang tidak boleh kosong");
        }
    }

    public void nullCheckBarangQuantity(Integer qty) throws ClientException {
        if(qty == null) {
            throw new ClientException("Jumlah barang Barang tidak boleh kosong");
        }
    }

    public void nullCheckBarangPrice(Double harga) throws ClientException {
        if(harga == null) {
            throw new ClientException("Harga Barang tidak boleh kosong");
        }
    }

    public void validateNoBarang (Integer no) throws ClientException{
        if (no <= 0){
            throw new ClientException("Id Cicilan tidak valid");
        }
    }

    public void validateBarangName(String barangName) throws ClientException {
        if(barangName.length() > 30) {
            throw new ClientException("Nama barang tidak boleh melebihi 30 huruf.");
        }
    }


    public void validateBarangDesc(String desk) throws ClientException {
        if(desk.length() > 150) {
            throw new ClientException("Deskripsi barang tidak boleh melebihi 150 huruf.");
        }
    }

    public void validateBarangQuantity(Integer qty) throws ClientException {
        if(qty < 1) {
            throw new ClientException("Jumlah barang tidak valid");
        }
    }

    public void validateBarangPrice(Double harga) throws ClientException {
        if(harga < 1) {
            throw new ClientException("Harga barang tidak valid");
        }
    }

    public void validateTransStatus (String noTransaksi, String status) throws ClientException{
        if (status.equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE)){
            throw new ClientException("Cicilan dengan nomor transaksi = " + noTransaksi+" telah dihapus");
        }
    }
}
