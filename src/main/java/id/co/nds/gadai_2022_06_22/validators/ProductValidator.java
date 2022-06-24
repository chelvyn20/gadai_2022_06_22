package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

public class ProductValidator {
    public void nullChekcProductTipe(String tipe) throws ClientException{
        if(tipe==null){
            throw new ClientException( "Tipe produk tidak boleh kosong");

        }
    }

    public void nullChekcProductId(String id) throws ClientException{
        if(id==null){
            throw new ClientException( "Id produk tidak boleh kosong");

        }
    }
    
    public void notnullChekcProductId(String id ) throws ClientException {
        if(id!=null){
            throw new ClientException( "Id produk dibuat secara otomatis, jangan masukkan id!");

        }
    }
    
    public void nullChekcProductName(String name ) throws ClientException {
        if(name==null){
            throw new ClientException( "Nama produk tidak boleh kosong");

        }
    }

    public void nullChekcProductJangkaWaktu(Integer waktu ) throws ClientException {
        if(waktu==null){
            throw new ClientException( "Jangka waktu produk tidak boleh kosong");

        }
    }

    public void nullChekcProductLtv(Double ltv ) throws ClientException {
        if(ltv==null){
            throw new ClientException( "Ltv produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminBuka(Double biayaBuka ) throws ClientException {
        if(biayaBuka==null){
            throw new ClientException( "Biaya buka produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminBukaTipe(String tipeBuka ) throws ClientException {
        if(tipeBuka==null){
            throw new ClientException( "Tipe buka produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminTutup(Double biayaTutup ) throws ClientException {
        if(biayaTutup==null){
            throw new ClientException( "Biaya tutup produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminTutupTipe(String tipeTutup ) throws ClientException {
        if(tipeTutup==null){
            throw new ClientException( "Tipe tutup produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminPeny(Double biayaPeny ) throws ClientException {
        if(biayaPeny==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminPenyPeriode(Integer periodePeny ) throws ClientException {
        if(periodePeny==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminDenda(Double biayaDenda ) throws ClientException {
        if(biayaDenda==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }

    public void nullChekcBiayaAdminDendaPeriode(Integer periodeDenda ) throws ClientException {
        if(periodeDenda==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }    

    public void nullChekcObject( Object o) throws NotFoundException{
        if(o ==null){
            throw new NotFoundException( "Id produk tidak ditemukan");

        }
    }

    public void validateProductTipe(String tipe) throws ClientException{
        if(tipe.trim().equalsIgnoreCase(" ")){
            throw new ClientException( "Tipe produk tidak boleh kosong");
        }
    }

    public void validateProductId (String id) throws ClientException{
        if (id.trim().equalsIgnoreCase(" ")){
            throw new ClientException("Id produk tidak boleh kosong");
        }
    }
    
    public void validateName (String name) throws ClientException{
        if (name.trim().equalsIgnoreCase(" ")){
            throw new ClientException("Nama produk tidak boleh kosong");
        }
    }

    public void validateProductJangkaWaktu(Integer waktu ) throws ClientException {
        if(waktu==null){
            throw new ClientException( "Jangka waktu produk tidak boleh kosong");

        }
    }

    public void validateProductLtv(Double ltv ) throws ClientException {
        if(ltv==null){
            throw new ClientException( "Ltv produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminBuka(Double biayaBuka ) throws ClientException {
        if(biayaBuka==null){
            throw new ClientException( "Biaya buka produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminBukaTipe(String tipeBuka ) throws ClientException {
        if(tipeBuka==null){
            throw new ClientException( "Tipe buka produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminTutup(Double biayaTutup ) throws ClientException {
        if(biayaTutup==null){
            throw new ClientException( "Biaya tutup produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminTutupTipe(String tipeTutup ) throws ClientException {
        if(tipeTutup==null){
            throw new ClientException( "Tipe tutup produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminPeny(Double biayaPeny ) throws ClientException {
        if(biayaPeny==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminPenyPeriode(Integer periodePeny ) throws ClientException {
        if(periodePeny==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminDenda(Double biayaDenda ) throws ClientException {
        if(biayaDenda==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }

    public void validateBiayaAdminDendaPeriode(Integer periodeDenda ) throws ClientException {
        if(periodeDenda==null){
            throw new ClientException( "Biaya penyimpanan produk tidak boleh kosong");

        }
    }    


    public void validateProductStatus (String id, String status) throws ClientException{
        if (status.equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE)){
            throw new ClientException("Pelanggan dengan id = " + id+" telah dihapus");
        }
    }

}
