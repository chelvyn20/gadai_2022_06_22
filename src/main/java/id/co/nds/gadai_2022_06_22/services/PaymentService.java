package id.co.nds.gadai_2022_06_22.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.DendaEntity;
import id.co.nds.gadai_2022_06_22.entities.PaymentEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.PaymentModel;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.CustomerRepo;
import id.co.nds.gadai_2022_06_22.repos.DendaRepo;
import id.co.nds.gadai_2022_06_22.repos.PaymentRepo;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.PaymentSpec;
import id.co.nds.gadai_2022_06_22.validators.PaymentValidator;
import id.co.nds.gadai_2022_06_22.validators.TrxValidator;


@Service
public class PaymentService {
    @Autowired
    private CicilanRepo cicilanRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private CicilanTetapRepo cicilanTetapRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private DendaRepo dendaRepo;

   
    PaymentValidator paymentValidator = new PaymentValidator();
    TrxValidator trxValidator = new TrxValidator();  

    public List<CicilanTetapEntity> findPaymentByCriteria(PaymentModel paymentModel){
        List<PaymentEntity> payment = new ArrayList<>();
        PaymentSpec paymentSpec = new PaymentSpec(paymentModel);
        paymentRepo.findAll(paymentSpec).forEach(payment::add);
        ArrayList param = new ArrayList();
        for(int i=0; i < payment.size(); i++){
            CicilanTetapEntity cicilanTetap = cicilanTetapRepo.findById(payment.get(i).getNoTransaksi()).orElse( null);
            CustomerEntity customer = customerRepo.findById(cicilanTetap.getCustId()).orElse( null);
            List<CicilanEntity> cicilan = cicilanRepo.findAll();
         
           
            param.add("No Transaksi: " + payment.get(i).getNoTransaksi());
            param.add("Tgl Transaksi: " + cicilanTetap.getTanggalTx());
            param.add("Id Pelanggan: " + cicilanTetap.getCustId());
            param.add("No KTP: " + customer.getCustKtp());
            param.add("Nama Pelanggan: " + customer.getCustName());
            param.add("Cicilan Ke: " + cicilan.get(i).getCicilanKe());
            param.add("Total Tagihan: " + payment.get(i).getTotalTagihan() ) ;
            param.add("Status Cicilan: " + cicilan.get(i).getStatusTrans());
            param.add("Tgl Aktif Cicilan: " + cicilan.get(i).getTglAktif());
            param.add("tgl Jatuh Tempo Cicilan: " + cicilan.get(i).getTglJatuhTempo());
            
        }
        return param;
    
    }

    public List<CicilanTetapEntity> findByNoTrans(String nomor) throws ClientException, NotFoundException{
        
        trxValidator.nullChekcNoTrans(nomor);
        trxValidator.validateNoTrans(nomor);
        CicilanTetapEntity trx = cicilanTetapRepo.findById(nomor).orElse( null);
        trxValidator.nullChekcObject(trx);
        CustomerEntity customer = customerRepo.findById(trx.getCustId()).orElse( null);
        ProductEntity product = productRepo.findById(trx.getProductId()).orElse( null);

        List <CicilanEntity> cicilan = new ArrayList<>();
        Double totalKewajiban = 0.00;
        for (int i =0; i< cicilan.size(); i++){
          if(cicilan.get(i).getNoTransaksi() == nomor){
            totalKewajiban += cicilan.get(i).getTxPokok() + cicilan.get(i).getTxBunga();
          }

        }

        List<DendaEntity> denda = new ArrayList<>();
        Double totalDenda = 0.00;
        for (int i =0; i< denda.size(); i++){
          if(denda.get(i).getNoTransaksi() == nomor){
            totalDenda += denda.get(i).getBiayaDenda();
          }

        }

        List <PaymentEntity> payment = new ArrayList<>();
        Double totalPembayaran = 0.00;
        for (int i =0; i< payment.size(); i++){
          if(payment.get(i).getNoTransaksi() == nomor){
            totalPembayaran += payment.get(i).getJumlahPembayaran();
          }

        }

        
        ArrayList param = new ArrayList();
       
        param.add("Pelanggan: " + trx.getCustId() +" - " + customer.getCustName());
        param.add("Tgl Transaksi: " + trx.getTanggalTx());
        param.add("Nomor Transaksi: " + trx.getNoTransaksi());
        param.add("Total Nilai Pinjam: " + trx.getTotalNilaiPinjaman());
        param.add("Tenor: " + product.getProductJangkaWaktu());
        param.add("Tgl Jatuh Tempo: " + trx.getTglJatuhTempo());
        param.add("Produk Transaksi: " + trx.getProductId() );
        param.add("Nama Produk: " + product.getProductName());
        param.add("Keterangan Produk: "  +  product.getProductDesc());
        param.add("Total Kewajiwan: "+ totalKewajiban);
        param.add("Total Denda: " + totalDenda);
        param.add("Total Pembayaran: " + totalPembayaran);
        param.add("Sisa Kewajiban: " + (totalKewajiban + totalDenda - totalPembayaran ));
        param.add("Detail Transaksi: " );
        
        
         return param;
       
    }

    public CicilanTetapEntity findById(String noTrans) throws ClientException, NotFoundException{
        trxValidator.nullChekcNoTrans(noTrans);
        trxValidator.validateNoTrans(noTrans);

        CicilanTetapEntity cicilanTetap = cicilanTetapRepo.findById(noTrans).orElse( null);
        trxValidator.nullChekcObject(cicilanTetap);
        return cicilanTetap;
    }
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CicilanTetapEntity edit (PaymentModel paymentModel)
    throws ClientException,NotFoundException{
       //validation
      
       trxValidator.nullChekcNoTrans(paymentModel.getNoTransaksi());
       trxValidator.validateNoTrans(paymentModel.getNoTransaksi());
       
       if(!cicilanTetapRepo.existsById(paymentModel.getNoTransaksi())){
           throw new NotFoundException( "Nomor Transaksi Tidak Ditemukan");
       }

       if(paymentModel.getSelectedNoCic() ==null){
            throw new NotFoundException( "Cicilan ke- titak boleh kosong");
        }

      List<CicilanEntity> cicilan = new ArrayList<>();
      for(int i=0; i<cicilan.size(); i++){
        if (paymentModel.getSelectedNoCic() != cicilan.get(i).getCicilanKe()){
            throw new NotFoundException( "Cicilan Ke Tidak Ditemukan. Silahkan pilih cicilan ke 1-" + (cicilan.size()-1));
        }
      }

      CicilanTetapEntity cicilanTetap = new CicilanTetapEntity();
      cicilanTetap=findById(paymentModel.getNoTransaksi());

      PaymentEntity payment = new PaymentEntity();
      Integer index= 0;

      for(int i=0; i<cicilan.size(); i++){
        if (paymentModel.getSelectedNoCic() == cicilan.get(i).getCicilanKe()){
           index = i;
        }
      }


      List<DendaEntity> denda = new ArrayList<>();
      Double totalDenda = 0.00;
      for(int i =0; i<denda.size(); i++){
          if (denda.get(i).getNoTransaksi()== paymentModel.getNoTransaksi() && denda.get(i).getCicilanKe() == paymentModel.getSelectedNoCic()){
            totalDenda += denda.get(i).getBiayaDenda();
          }
      }

      payment.setTotalTagihanCicilan(cicilan.get(index).getTxPokok()+cicilan.get(index).getTxBunga());
      payment.setTotalTagihanDenda(totalDenda);
      
      if (paymentModel.getSelectedNoCic() == cicilan.get(cicilan.size()-1).getCicilanKe()){
        payment.setBiayaAdmTutup(cicilanTetap.getBiayaAdmTutup()); 

      }
      else{
        payment.setBiayaAdmTutup(null); 
      }

      paymentRepo.save(payment);
      Double diskon = cicilanTetap.getDiskonAdmBuka();
      if(diskon > (cicilanTetap.getTotalBiayaJasaPeny() + totalDenda)){
        throw new NotFoundException( "Diskon tidak boleh  [total biaya jasa penyimpanan + denda ]");
      }
      payment.setTotalTagihan(payment.getTotalTagihan() + payment.getTotalTagihanDenda() + payment.getBiayaAdmTutup() - diskon);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
      paymentRepo.save(payment);
      Double pembulatan = payment.getTotalTagihan();
      pembulatan = pembulatan - (pembulatan%100);
      payment.setPembulatan(pembulatan);
      paymentValidator.nullJumlahPembayaran(paymentModel.getJumlahPembayaran());
      paymentValidator.nullMetodePembayaran(paymentModel.getMetodeBayar());
      paymentValidator.validateJumlahPembayaran(paymentModel.getJumlahPembayaran(), pembulatan);
      paymentValidator.validateMetodePembayaran(paymentModel.getMetodeBayar());
      payment.setJumlahPembayaran(paymentModel.getJumlahPembayaran());
      payment.setMetodeBayar(paymentModel.getMetodeBayar());

      paymentRepo.save(payment);

      cicilan.get(index).setStatusTrans(GlobalConstant.STATUS_LUNAS);
      cicilan.get(index).setTglBayar(LocalDate.now());
      cicilan.get(index).setNoPembayaran(payment.getNoPembayaran());

      cicilanRepo.saveAll(cicilan);

      for(int i =0; i<denda.size(); i++){
        if (denda.get(i).getNoTransaksi()== paymentModel.getNoTransaksi() && denda.get(i).getCicilanKe() == paymentModel.getSelectedNoCic()){
          denda.get(i).setTglByrDenda(LocalDate.now());
          denda.get(i).setNoPembayaran(payment.getNoPembayaran());
        }
    }

      dendaRepo.saveAll(denda);

      cicilanTetap.setStatusTrans(GlobalConstant.STATUS_LUNAS);

      for(int i=0; i<cicilan.size(); i++){
        if(cicilan.get(i).getStatusTrans() != GlobalConstant.STATUS_LUNAS){
          cicilanTetap.setStatusTrans(GlobalConstant.STATUS_AKTIF);
        }
      }

      
       return cicilanTetapRepo.save(cicilanTetap);
    }

    
    
}
