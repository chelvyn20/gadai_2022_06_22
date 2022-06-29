package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;

public class CicilanTetapValidator {
    public void notNullCheckTransaksiNo(String noTransaksi) throws ClientException{
        if(noTransaksi != null) {
            throw new ClientException("No transaksi dibuat secara otomatis, jangan masukan no transaksi");
        }
    }

    public void nullCheckTransaksiNo(String noTransaksi) throws ClientException {
        if(noTransaksi == null) {
            throw new ClientException("No Transaksi perlu diisi");
        }
    }

    public void nullChecNilaiPencairanPelanggan(Double nilaiPencairanPelanggan) throws ClientException {
        if(nilaiPencairanPelanggan == null) {
            throw new ClientException("Nilai Pencairan Pelanggan perlu diisi");
        }
    }

    public void nullCheckDiskonAdmBuka(Double diskonAdmBuka) throws ClientException {
        if(diskonAdmBuka == null) {
            throw new ClientException("Diskon Admin Buka perlu diisi");
        }
    }
    
    public void nullCheckObject(Object o) throws NotFoundException {
        if(o == null) {
            throw new NotFoundException("Transaksi tidak ditemukan");
        }
    }

    public void validateTransaksiNo(String noTransaksi) throws ClientException {
        if(noTransaksi.length() <= 11) {
            throw new ClientException("No Transaksi tidak valid");
        }
    }

    public void validateNilaiPencairanPelanggan(Double nilaiPencairanPelanggan) throws ClientException {
        if(nilaiPencairanPelanggan < 1000000) {
            throw new ClientException("Minimal jumlah pencairan adalah 1.000.000");
        }

        if(nilaiPencairanPelanggan > 3000000) {
            throw new ClientException("Maksimal jumlah pencairan adalah 3.000.000");
        }
    }

    public void validateDiskonAdmBuka(Double diskonAdmBuka) throws ClientException {
        if(diskonAdmBuka > 100 || diskonAdmBuka < 0) {
            throw new ClientException("Diskon admin buka tidak valid");
        }
    }
}
