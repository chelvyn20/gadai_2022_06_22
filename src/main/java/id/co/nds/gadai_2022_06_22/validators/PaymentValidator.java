package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;

public class PaymentValidator {
   

    public void nullJumlahPembayaran(Double pay ) throws ClientException {
        if(pay!=null){
            throw new ClientException( "Jumlah pembayaran tidak boleh kosong");

        }
    }
    public void nullMetodePembayaran(String metode ) throws ClientException {
        if(metode!=null){
            throw new ClientException( "metode pembayaran tidak boleh kosong");
            

        }
    }

    public void validateJumlahPembayaran(Double pay , Double total ) throws ClientException {
        if(pay < total){
            throw new ClientException( "jumlah pembayaran tidak boleh lebih kecil dari yang ditagihkan");

        }
    }

    public void validateMetodePembayaran(String metode ) throws ClientException {
        if(!metode.trim().equalsIgnoreCase("CASH")  && !metode.trim().equalsIgnoreCase("TRANSFER")  && !metode.trim().equalsIgnoreCase("DEBIT")  && !metode.trim().equalsIgnoreCase("CREDIT")){
            throw new ClientException( "metode pembayaran yang tersedia:  CASH / TRANSFER / DEBIT / CREDIT");

        }
    }
    
}
