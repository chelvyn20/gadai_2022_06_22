package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;

public class ProductValidator {
    public void nullCheckId(Integer id) throws ClientException{
        if(id == null) {
            throw new ClientException("Id perlu diisi");
        }
    }

    public void notNullCheckId(Integer id) throws ClientException{
        if(id != null) {
            throw new ClientException("Id dibuat secara otomatis, jangan masukan id");
        }
    }

    public void nullCheckProductId(String productId) throws ClientException {
        if(productId == null) {
            throw new ClientException("Produk id perlu diisi");
        }
    }

    public void nullCheckProductName(String productName) throws ClientException {
        if(productName == null) {
            throw new ClientException("Nama produk perlu diisi");
        }
    }

    public void nullCheckProductType(String productType) throws ClientException {
        if(productType == null) {
            throw new ClientException("Tipe produk perlu diisi");
        }
    }

    public void nullCheckJangkaWaktu(Integer jangkaWaktu) throws ClientException {
        if(jangkaWaktu == null) {
            throw new ClientException("Jangka waktu perlu diisi");
        }
    }

    public void nullCheckLtv(Double productLtv) throws ClientException {
        if(productLtv == null) {
            throw new ClientException("Ltv perlu diisi");
        }
    }

    public void nullCheckProductAdminOpeningFeeType(String openingType) throws ClientException {
        if(openingType == null) {
            throw new ClientException("Jenis biaya admin buka perlu diisi");
        }
    }

    public void nullCheckProductAdminClosingFeeType(String closingType) throws ClientException {
        if(closingType == null) {
            throw new ClientException("Jenis biaya admin tutup perlu diisi");
        }
    }

    public void nullCheckProductAdminOpeningFee(Double openingFee) throws ClientException {
        if(openingFee == null) {
            throw new ClientException("Biaya admin buka perlu diisi");
        }
    }

    public void nullCheckProductAdminClosingFee(Double closingFee) throws ClientException {
        if(closingFee == null) {
            throw new ClientException("Biaya admin tutup perlu diisi");
        }
    }
    
    public void nullCheckProductBiayaPenyimpanan(Double biayaPenyimpanan) throws ClientException {
        if(biayaPenyimpanan == null) {
            throw new ClientException("Biaya penyimpanan perlu diisi");
        }
    }

    public void nullCheckProductBiayaPenyimpananPeriode(Integer periodePeny) throws ClientException {
        if(periodePeny == null) {
            throw new ClientException("Periode penyimpanan perlu diisi");
        }
    }

    public void nullCheckProductBiayaDenda(Double productBiayaDenda) throws ClientException {
        if(productBiayaDenda == null) {
            throw new ClientException("Biaya denda perlu diisi");
        }
    }

    public void nullCheckProductBiayaDendaPeriode(Integer productBiayaDendaPeriode) throws ClientException {
        if(productBiayaDendaPeriode == null) {
            throw new ClientException("Periode denda perlu diisi");
        }
    }

    public void nullCheckObject(Object o) throws NotFoundException {
        if(o == null) {
            throw new NotFoundException("Produk tidak ditemukan");
        }
    }

    public void validateId(Integer id) throws ClientException {
        if(id <= 0) {
            throw new ClientException("Input id tidak valid");
        }
    }

    public void validateProductId(String productId) throws ClientException {
        if(productId.length() > 20) {
            throw new ClientException("Produk id tidak boleh melebihi 15 huruf");
        }
    }

    public void validateProductName(String productName) throws ClientException {
        if(productName.length() > 50) {
            throw new ClientException("Nama produk tidak boleh melebihi 50 huruf");
        }
    }

    public void validateProductType(String productType) throws ClientException {
        if(!productType.equalsIgnoreCase("konsinyasi cicilan tetap") && !productType.equalsIgnoreCase("konsinyasi cicilan fleksibel")) {
            throw new ClientException("Tipe produk harus berisikan 'Konsinyasi Cicilan Tetap' atau 'Konsinyasi Cicilan Fleksibel'");
        }
    }

    public void validateProductDesc(String productDesc) throws ClientException {
        if(productDesc.length() > 255) {
            throw new ClientException("Keterangan Produk hanya boleh berisikan paling banyak 255 huruf");
        }
    }

    public void validateJangkaWaktu(Integer jangkaWaktu, String productType) throws ClientException {
        if(productType.equalsIgnoreCase("Konsinyasi Cicilan Tetap")) {
            if(jangkaWaktu < 1)
                throw new ClientException("Jangka waktu tidak valid");
        } else if(productType.equalsIgnoreCase("Konsinyasi Cicilan Fleksibel")) {
            if(jangkaWaktu < 1)
                throw new ClientException("Jangka waktu tidak valid");
        } else throw new ClientException("Jenis tipe produk tidak diketahui.");
    }

    public void validateProductLtv(Double productLtv) throws ClientException {
        if(productLtv < 0) {
            throw new ClientException("Ltv tidak valid");
        }
        
        if(productLtv > 0.85) {
            throw new ClientException("Ltv tidak boleh melebihi 85%");
        }
    }

    public void validateProductAdminOpeningFeeType(String openingType) throws ClientException {
        if(!openingType.equalsIgnoreCase("persen") && !openingType.equalsIgnoreCase("nominal")) {
            throw new ClientException("Tipe biaya admin buka harus berisikan 'Persen' atau 'Nominal'");
        }
    }

    public void validateProductAdminClosingFeeType(String openingType) throws ClientException {
        if(!openingType.equalsIgnoreCase("PERSEN") && !openingType.equalsIgnoreCase("NOMINAL")) {
            throw new ClientException("Tipe biaya admin tutup harus berisikan 'Persen' atau 'Nominal'");
        }
    }

    public void validateProductAdminOpeningFee(Double openingFee) throws ClientException {
        if(openingFee < 0) {
            throw new ClientException("Biaya admin buka tidak valid");
        }
    }

    public void validateProductAdminClosingFee(Double closingFee) throws ClientException {
        if(closingFee < 0) {
            throw new ClientException("Biaya admin tutup tidak valid");
        }
    }

    public void validateProductBiayaPenyimpanan(Double biayaPenyimpanan) throws ClientException {
        if(biayaPenyimpanan < 0) {
            throw new ClientException("Biaya jasa penyimpanan tidak valid");
        }
    }

    public void validateProductBiayaPenyimpananPeriode(Integer periodePeny, Integer jangkaWaktu, String productType) throws ClientException {
        if(periodePeny < 0) {
            throw new ClientException("Periode jasa penyimpanan tidak valid");
        }

        if(periodePeny > jangkaWaktu) {
            throw new ClientException("Periode biaya jasa penyimpanan tidak boleh lebih besar daripada jangka waktu");
        }

        if(jangkaWaktu % periodePeny > 0) {
            throw new ClientException("Periode biaya jasa penyimpanan harus merupakan suatu kelipatan dari jangka waktu");
        }
    }

    public void validateProductBiayaDenda(Double productBiayaDenda) throws ClientException {
        if(productBiayaDenda < 0) {
            throw new ClientException("Biaya denda tidak valid");
        }
    }

    public void validateProductBiayaDendaPeriode(Integer productBiayaDendaPeriode) throws ClientException {
        if(productBiayaDendaPeriode < 0) {
            throw new ClientException("Periode denda tidak valid");
        }
    }
}
