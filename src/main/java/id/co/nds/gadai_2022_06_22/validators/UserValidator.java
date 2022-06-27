package id.co.nds.gadai_2022_06_22.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;

public class UserValidator {
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

    public void nullCheckUserId(String id) throws ClientException {
        if(id == null) {
            throw new ClientException("User id perlu diisi");
        }
    }

    public void nullCheckUserName(String name) throws ClientException {
        if(name == null) {
            throw new ClientException("Nama perlu diisi");
        }
    }

    public void nullCheckUserPhoneNumber(String phoneNumber) throws ClientException {
        if(phoneNumber == null) {
            throw new ClientException("No hp perlu diisi");
        }
    }

    public void nullCheckUserMaxTransaction(Double userMaxTransaction) throws ClientException {
        if(userMaxTransaction == null) {
            throw new ClientException("Maksimal Limit Transaksi User perlu diisi");
        }
    }

    public void nullCheckUserEntryDate(String entryDate) throws ClientException {
        if(entryDate == null) {
            throw new ClientException("Tanggal masuk perlu diisi");
        }
    }
    
    public void nullCheckObject(Object o) throws NotFoundException {
        if(o == null) {
            throw new NotFoundException("User tidak ditemukan");
        }
    }

    public void validateId(Integer id) throws ClientException {
        if(id <= 0) {
            throw new ClientException("Input id tidak valid");
        }
    }

    public void validateUserId(String userId) throws ClientException {
        if(userId.length() > 15) {
            throw new ClientException("User id tidak boleh melebihi 15 huruf");
        }
    }

    public void validateUserName(String name) throws ClientException {
        if(name.trim().equalsIgnoreCase("")) {
            throw new ClientException("Nama tidak boleh kosong");
        }
    }

    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }

    public void validatePhoneNumber(String phoneNumber) throws ClientException {

        if(!isNumeric(phoneNumber)) {
            throw new ClientException("Nomor Hp harus berisikan angka");
        }

        if(!phoneNumber.startsWith("0") || phoneNumber.length() < 9 || phoneNumber.length() > 12) {
            throw new ClientException("Nomor Hp dimulai dari angka 0 dan berisikan 9 - 12 digit");
        }
    }

    public void validateUserTransactionLimit(Double userTxnLimit) throws ClientException {
        if(userTxnLimit < 500000 || userTxnLimit > 1000000) {
            throw new ClientException("Minimal limit 500.000 dan Maksimal limit 1.000.000");
        }
    }

    public void validateUserDesc(String desc) throws ClientException {
        if(desc.length() > 50) {
            throw new ClientException("Deskripsi user tidak boleh melebihi 50 huruf.");
        }
    }

    public void validateEntryDate(String entryDate) throws ClientException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate formatedDate = LocalDate.parse(entryDate, dateFormat);

        LocalDate now = LocalDate.now();

        if(formatedDate.compareTo(now) > 0){
            throw new ClientException("Tanggal masuk tidak boleh melebihi hari ini");
        }
    }
}
