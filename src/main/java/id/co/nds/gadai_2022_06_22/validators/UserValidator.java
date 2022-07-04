package id.co.nds.gadai_2022_06_22.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;

public class UserValidator {
    public void notNullCheckUserId(String userId) throws ClientException{
        if(userId != null) {
            throw new ClientException("Id dibuat secara otomatis, jangan masukan id");
        }
    }

    public void nullCheckUserId(String userId) throws ClientException {
        if(userId == null) {
            throw new ClientException("User id perlu diisi");
        }
    }

    public void nullCheckUserName(String userName) throws ClientException {
        if(userName == null) {
            throw new ClientException("Nama perlu diisi");
        }
    }

    public void nullCheckUserPhoneNumber(String userPhone) throws ClientException {
        if(userPhone == null) {
            throw new ClientException("No hp perlu diisi");
        }
    }

    public void nullCheckUserMaxLimit(Double userMaxLimit) throws ClientException {
        if(userMaxLimit == null) {
            throw new ClientException("Maksimal Limit Transaksi User perlu diisi");
        }
    }

    public void nullCheckUserEntryDate(String userRegisterDate) throws ClientException {
        if(userRegisterDate == null) {
            throw new ClientException("Tanggal masuk perlu diisi");
        }
    }
    
    public void nullCheckObject(Object o) throws NotFoundException {
        if(o == null) {
            throw new NotFoundException("User tidak ditemukan");
        }
    }

    public void validateUserId(String userId) throws ClientException {
        if(userId.length() > 15) {
            throw new ClientException("User id tidak boleh melebihi 15 huruf");
        }
    }

    public void validateUserName(String userName) throws ClientException {
        if(userName.trim().equalsIgnoreCase("")) {
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

    public void validatePhoneNumber(String userPhone) throws ClientException {

        if(!isNumeric(userPhone)) {
            throw new ClientException("Nomor Hp harus berisikan angka");
        }

        if(!userPhone.startsWith("0") || userPhone.length() < 9 || userPhone.length() > 12) {
            throw new ClientException("Nomor Hp dimulai dari angka 0 dan berisikan 9 - 12 digit");
        }
    }

    public void validateUserTransactionLimit(Double userMaxLimit) throws ClientException {
        if(userMaxLimit < 500000 || userMaxLimit > 1000000) {
            throw new ClientException("Minimal limit 500.000 dan Maksimal limit 1.000.000");
        }
    }

    public void validateUserNotes(String userNotes) throws ClientException {
        if(userNotes.length() > 50) {
            throw new ClientException("Deskripsi user tidak boleh melebihi 50 huruf.");
        }
    }

    public void validateEntryDate(String userRegisterDate) throws ClientException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate formatedDate = LocalDate.parse(userRegisterDate, dateFormat);

        LocalDate now = LocalDate.now();

        if(formatedDate.compareTo(now) > 0){
            throw new ClientException("Tanggal masuk tidak boleh melebihi hari ini");
        }
    }
}
