package id.co.nds.gadai_2022_06_22.validators;

import org.apache.commons.lang3.StringUtils;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

public class CustomerValidator {
    public void nullCheckCustId(String id) throws ClientException {
        if (id == null) {
            throw new ClientException("Id pelanggan tidak boleh kosong");

        }
    }

    public void notnullCheckCustId(String id) throws ClientException {
        if (id != null) {
            throw new ClientException("Id pelanggan dibuat secara otomatis, jangan masukkan id!");

        }
    }

    public void nullCheckCustName(String name) throws ClientException {
        if (name == null) {
            throw new ClientException("Nama pelanggan tidak boleh kosong");

        }
    }

    public void nullCheckCustKtp(String ktp) throws ClientException {
        if (ktp == null) {
            throw new ClientException("Nomor KTP pelanggan tidak boleh kosong");

        }
    }

    public void nullCheckCallNumber(String callNumber) throws ClientException {
        if (callNumber == null) {
            throw new ClientException("Nomor HP pelanggan tidak boleh kosong");

        }
    }

    public void nullCheckCustJk(String jk) throws ClientException {
        if (jk == null) {
            throw new ClientException("Jenis kelamin pelanggan tidak boleh kosong");

        }
    }

    public void nullCheckCustJenisUsaha(String usaha) throws ClientException {
        if (usaha == null) {
            throw new ClientException("Jenis usaha pelanggan tidak boleh kosong");

        }
    }

    public void nullCheckCustLimitTxn(Double limit) throws ClientException {
        if (limit == null) {
            throw new ClientException("Batas transaksi pelanggan tidak boleh kosong");

        }
    }

    public void nullCheckObject(Object o) throws NotFoundException {
        if (o == null) {
            throw new NotFoundException("Id pelanggan tidak ditemukan");

        }
    }

    public void validateCustId(String id) throws ClientException {
        if (id.length() != 10 || !id.startsWith("YYMM")) {
            throw new ClientException("Id pelanggan harus 10 digit dan dimulai dengan format 'YYMM'");
        }
    }

    public void validateName(String name) throws ClientException {
        if (name.trim().equalsIgnoreCase(" ")) {
            throw new ClientException("Nama pelanggan tidak boleh kosong");
        }
    }

    public void validateCustKtp(String ktp) throws ClientException {
        if (ktp.length() != 16) {
            throw new ClientException("Nomor KTP tidak valid, harus 10 digit");
        }

        if (!(StringUtils.isNumeric(ktp))) {
            throw new ClientException("Nomor KTP tidak valid, harus semuanya angka");

        }
    }

    public void validateCallNumber(String callNumber) throws ClientException {
        if (!(callNumber.length() <= 12) || !(callNumber.length() >= 9 || !(StringUtils.isNumeric(callNumber)))) {
            throw new ClientException("Nomor HP pelanggan harus 9-12 digit, masukkan hanya angka ");
        }

    }

    public void validateCustJk(String jk) throws ClientException {

        if (!"P".equals(jk) && !"W".equals(jk)) {
            throw new ClientException(" Masukan Salah, Masukkan 'P' atau 'W'");
        }

    }

    public void validateJenisUsaha(String usaha) throws ClientException {
        if (usaha.trim().equalsIgnoreCase(" ")) {
            throw new ClientException("Jenis Usaha pelanggan tidak boleh kosong");
        }
    }

    public void validatetLimitTxn(Double limit) throws ClientException {
        if (!(limit >= 1000000.00) || !(limit <= 3000000.00)) {

            throw new ClientException("Batas transaksi pelanggan adalah 1.000.000,00 - 3.000.000,00");
        }

    }

    public void validateCustStatus(String id, String status) throws ClientException {
        if (status.equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE)) {
            throw new ClientException("Pelanggan dengan id = " + id + " telah dihapus");
        }
    }
}
