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
        if(!tipe.trim().equalsIgnoreCase("Konsinyasi Cicilan Tetap")  && !tipe.trim().equalsIgnoreCase("Konsinyasi Cicilan Fleksibel")  ){
            throw new ClientException( "Tipe produk harus diisi dengan 'Konsinyasi Cicilan Tetap' atau 'Konsinyasi Cicilan Fleksibel'");
        }
    }

    public void validateProductId (String id) throws ClientException{
        if (id.trim().equalsIgnoreCase(" ") || id.length() > 20){
            throw new ClientException("Id produk tidak boleh kosong dan tidak boleh melebihi 20 karakter");
        }
    }
    
    public void validateName (String name) throws ClientException{
        if (name.trim().equalsIgnoreCase(" ") || name.length() > 50) {
            throw new ClientException("Nama produk tidak boleh kosong dan tidak boleh melebihi 50 huruf");
        }
    }

    public void validateProductJangkaWaktu(String tipe, Integer waktu ) throws ClientException {
        if(waktu < 1 ){
            throw new ClientException( "Jangka waktu produk harus lebih besar dari 0");

        }
    }
    public void validateProductDesc(String desc) throws ClientException {
        if(desc.length() > 255) {
            throw new ClientException("Keterangan Produk tidak boleh lebih dari 255 karakter");
        }
    }

    public void validateProductLtv(Double ltv ) throws ClientException {
        if(ltv>0.85 || ltv <0 ){
            throw new ClientException( "Ltv produk harus diisi dalam bentuk persen (minimum 0 dan maksimum 85%)");

        }
    }

    public void validateBiayaAdminBuka(String tipeBuka, Double biayaBuka ) throws ClientException {
        
        if(biayaBuka <0){
            throw new ClientException( "Biaya buka produk tidak valid");
        }
        if(tipeBuka.trim().equalsIgnoreCase("persen")&& biayaBuka >1.00){
            throw new ClientException( "Biaya buka produk dalam bentuk persen (min: 0.00, maks: 1.00)");
        }
        
        
    }

    public void validateBiayaAdminBukaTipe(String tipeBuka ) throws ClientException {
        if(!tipeBuka.trim().equalsIgnoreCase("persen") && !tipeBuka.trim().equalsIgnoreCase("nominal")){
            throw new ClientException( "Tipe buka produk tidak valid, silahkan masukkan persen atau nominal");

        }
    }

    public void validateBiayaAdminTutup(String tipeTutup, Double biayaTutup ) throws ClientException {
        if(biayaTutup <0){
            throw new ClientException( "Biaya tutup produk tidak valid");
        }
        if(tipeTutup.trim().equalsIgnoreCase("persen")&& biayaTutup >1.00){
            throw new ClientException( "Biaya tutup produk dalam bentuk persen (min: 0.00, maks: 1.00)");
        }
    }

    public void validateBiayaAdminTutupTipe(String tipeTutup ) throws ClientException {
        if(!tipeTutup.trim().equalsIgnoreCase("persen") && !tipeTutup.trim().equalsIgnoreCase("nominal")){
            throw new ClientException( "Tipe tutup produk tidak valid, silahkan masukkan persen atau nominal");

        }
    }

    public void validateBiayaAdminPeny(Double biayaPeny ) throws ClientException {
        if(biayaPeny<0 || biayaPeny>9.99){
            throw new ClientException( "Biaya penyimpanan produk tidak valid");

        }
    }

    public void validateBiayaAdminPenyPeriode(Integer waktu, Integer periodePeny ) throws ClientException {
        if( (periodePeny > waktu) || waktu%periodePeny !=0 ){
            throw new ClientException( "Periode biaya penyimpanan produk tidak boleh lebih besar dari jangka waktu dan periode penyimpanan harus kelipatan dari jangka waktu");
        }
        if(periodePeny<0){
            throw new ClientException( "Periode biaya penyimpanan produk tidak valid");

        }
    }

    public void validateBiayaAdminDenda(Double biayaDenda ) throws ClientException {
        if(biayaDenda<0 || biayaDenda >9.99){
            throw new ClientException( "Biaya denda produk tidak valid");

        }
    }

    public void validateBiayaAdminDendaPeriode(Integer periodeDenda ) throws ClientException {
        if(periodeDenda<0 ){
            throw new ClientException( "Biaya penyimpanan produk tidak valid");

        }
    }    


    public void validateProductStatus (String id, String status) throws ClientException{
        if (status.equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE)){
            throw new ClientException("Pelanggan dengan id = " + id+" telah dihapus");
        }
    }

}
