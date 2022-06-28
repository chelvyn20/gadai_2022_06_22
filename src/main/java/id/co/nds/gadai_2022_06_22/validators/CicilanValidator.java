package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

public class CicilanValidator {
    public void nullChekcNoTrans(String noTrx) throws ClientException{
        if(noTrx==null){
            throw new ClientException( "Nomor Transaksi tidak boleh kosong");

        }
    }
    
    public void notnullChekcNoTrans(String noTrx ) throws ClientException {
        if(noTrx!=null){
            throw new ClientException( "Nomor Transaksi dibuat secara otomatis, jangan masukkan!");

        }
    }
    
    public void nullChekcProductId(String id ) throws ClientException {
        if(id==null){
            throw new ClientException( "Produk id tidak boleh kosong");

        }
    }

    public void nullChekcCustId(String ktp ) throws ClientException {
        if(ktp==null){
            throw new ClientException( "Nomor KTP Cicilan tidak boleh kosong");

        }
    }


    public void nullChekcObject( Object o) throws NotFoundException{
        if(o ==null){
            throw new NotFoundException( "No Transaksi tidak ditemukan");

        }
    }
    
    public void validateNoTrans (String id) throws ClientException{
        if (id.length()!=11 || !id.startsWith("YYMM")  ){
            throw new ClientException("Id Cicilan harus 11 digit dan dimulai dengan format 'YYMM'");
        }
    }
    
    public void validateProductId (String id) throws ClientException{
        
        if (id.length()!=6 || !id.startsWith("PRD")  ){
            throw new ClientException("Id Cicilan harus 6 digit dan dimulai dengan format 'PRD'");
        }
    }

    public void validateCustId (String id) throws ClientException{
        if (id.length()!=10 || !id.startsWith("YYMM")  ){
            throw new ClientException("Id Cicilan harus 10 digit dan dimulai dengan format 'YYMM'");
        }

    }    
    
    public void validateTransStatus (String id, String status) throws ClientException{
        if (status.equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE)){
            throw new ClientException("Cicilan dengan id = " + id+" telah dihapus");
        }
    }
}
