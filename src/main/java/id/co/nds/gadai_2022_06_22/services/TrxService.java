package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.BarangEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.DendaEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.TrxModel;
import id.co.nds.gadai_2022_06_22.repos.BarangRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.CustomerRepo;
import id.co.nds.gadai_2022_06_22.repos.DendaRepo;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.TrxSpec;
import id.co.nds.gadai_2022_06_22.repos.specs.CustomerSpec;
import id.co.nds.gadai_2022_06_22.validators.BarangValidator;
import id.co.nds.gadai_2022_06_22.validators.CustomerValidator;
import id.co.nds.gadai_2022_06_22.validators.ProductValidator;
import id.co.nds.gadai_2022_06_22.validators.TrxValidator;

@Service
public class TrxService implements Serializable {
    @Autowired
    private CicilanRepo cicilanRepo;

    @Autowired
    private CicilanTetapRepo cicilanTetapRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private BarangRepo barangRepo;

    @Autowired
    private DendaRepo dendaRepo;

   
    CustomerValidator customerValidator = new CustomerValidator();
    ProductValidator productValidator = new ProductValidator();
    BarangValidator barangValidator = new BarangValidator();
    TrxValidator trxValidator = new TrxValidator();  

    

    public List<CicilanTetapEntity> findTrxByCriteria(TrxModel trxModel){
        List<CicilanTetapEntity> transaksi = new ArrayList<>();
        
        TrxSpec trxSpec = new TrxSpec(trxModel);
        cicilanTetapRepo.findAll(trxSpec).forEach(transaksi::add);
        ArrayList param = new ArrayList();
        for(int i=0; i < transaksi.size(); i++){
            CustomerEntity customer = customerRepo.findById(transaksi.get(i).getCustId()).orElse( null);
            ProductEntity product = productRepo.findById(transaksi.get(i).getProductId()).orElse( null);
            List<CicilanEntity> cicilan = cicilanRepo.findAll();

            param.add("noTransaksi: " + transaksi.get(i).getNoTransaksi());
            param.add("tglTransaksi: " + transaksi.get(i).getTanggalTx());
            param.add("custId: " + transaksi.get(i).getCustId());
            param.add("custKtp: " + customer.getCustKtp());
            param.add("custName: " + customer.getCustName());
            param.add("productName: " + product.getProductName());
            param.add("tglJatuhTempo: " + transaksi.get(i).getTglJatuhTempo());
            param.add("statusTransaksi: " + cicilan.get(i).getStatusTrans());
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
        List<BarangEntity> barang = new ArrayList<>();
        barangRepo.findBarangByNoTrx(nomor).forEach(barang::add);
       
        
        ArrayList param = new ArrayList();
       
        param.add("custId: " + trx.getCustId());
        param.add("custName: " + customer.getCustName());
        param.add("productId: " + trx.getProductId());
        param.add("trxDate: " + trx.getTanggalTx());
        param.add("productName: " + product.getProductName());
        param.add("productDesc: " + product.getProductDesc());
        param.add("daftarBarangGadai: " );
        
        for(Object object : barang){
            param.add(object);
        }
       
        return param;
       
    }

    public List<CustomerEntity> findCustomerByCriteria(CustomerModel customerModel){
        List<CustomerEntity> customers = new ArrayList<>();
        CustomerSpec customerSpec = new CustomerSpec(customerModel);
        customerRepo.findAll(customerSpec).forEach(customers::add);
        ArrayList param = new ArrayList();
        for(int i=0; i < customers.size(); i++){
            param.add("custId: " + customers.get(i).getCustId());
            param.add("custKtp: " + customers.get(i).getCustKtp());
            param.add("custHp: " + customers.get(i).getCustHp());
            param.add("custName: " + customers.get(i).getCustName());
        }
        return param;
    }

  
    public List<ProductEntity> findAllProduct() {
        List<ProductEntity> product = new ArrayList<>();
        productRepo.findAllProductCiTetap().forEach(product::add);
        ArrayList param = new ArrayList<>();
        for (int i=0; i < product.size(); i++) {
            param.add("productId: " + product.get(i).getProductId());
            param.add("productName: " + product.get(i).getProductName());
            param.add("productDesc: " + product.get(i).getProductDesc());
        }
        return param;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CicilanTetapEntity count(TrxModel trxModel) throws ClientException{

        trxValidator.nullChekcProductId(trxModel.getProductId());
        trxValidator.validateProductId(trxModel.getProductId());

        Long count = productRepo.countProductIdCiTetap((trxModel.getProductId()));
        if(count<1){
            throw new ClientException("Id product tidak ditemukan");
  
        } 
        else if(count > 1){
            throw new ClientException("ga mungkin");
        }
        
        trxValidator.nullChekcNilaicairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        trxValidator.validateNilaicairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        trxValidator.nullChekcTotalNilaiTaksiran(trxModel.getTotalNilaiTaksiran());
        trxValidator.validateTotalNilaiTaksiran(trxModel.getTotalNilaiTaksiran());

        ProductEntity product = productRepo.findById(trxModel.getProductId()).orElse( null);
        CicilanTetapEntity transaksi =new CicilanTetapEntity();

        transaksi.setProductId(trxModel.getProductId());
        transaksi.setNilaiPencairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        transaksi.setDiskonAdmBuka(trxModel.getDiskonAdmBuka());
            

        if (trxModel.getDiskonAdmBuka()==null){
            transaksi.setDiskonAdmBuka(0.00);
        }
        else{
            trxValidator.validateDiskonAdminBuka(trxModel.getDiskonAdmBuka());
        }
        
        transaksi.setTxLtv( product.getProductLtv());
        transaksi.setMaxNilaiPinjam(trxModel.getTotalNilaiTaksiran() * product.getProductLtv());
        
        Double biayaBuka = 0.00;      
        if(product.getProductBiayaAdminBukaTipe().trim().equalsIgnoreCase("persen")){
            biayaBuka = trxModel.getNilaiPencairanPelanggan() * product.getProductBiayaAdminBuka();
        }
        else if( product.getProductBiayaAdminBukaTipe().trim().equalsIgnoreCase("nominal")){
            biayaBuka = product.getProductBiayaAdminBuka();
        }
        transaksi.setBiayaAdmBuka(biayaBuka);
        
        Double biayaAdmBukaAkhir = biayaBuka - (biayaBuka-trxModel.getDiskonAdmBuka()/100);
        transaksi.setBiayaAdmBukaAkhir(biayaAdmBukaAkhir);

        Double totalPinjaman = trxModel.getNilaiPencairanPelanggan()+biayaAdmBukaAkhir;
        transaksi.setTotalNilaiPinjaman(totalPinjaman);

        LocalDate tanggalSekang = LocalDate.now();
        transaksi.setTanggalTx(tanggalSekang);
        transaksi.setTglJatuhTempo(tanggalSekang.plusMonths(product.getProductJangkaWaktu())); 
        transaksi.setBiayaJasaPenyimpanan(product.getProductBiayaPeny());

        Double biayaPenyPer = product.getProductBiayaPeny()*totalPinjaman/(product.getProductJangkaWaktu()/product.getProductBiayaPenyPeriode());
        transaksi.setBiayaJasaPenyPeriode(biayaPenyPer);

        Double totalJasaPeny = product.getProductJangkaWaktu() /product.getProductBiayaPenyPeriode() * biayaPenyPer;
        transaksi.setTotalBiayaJasaPeny(totalJasaPeny);

        Double biayaTutup = 0.00;      
        if(product.getProductBiayaAdminTutupTipe().trim().equalsIgnoreCase("persen")){
            biayaTutup = trxModel.getNilaiPencairanPelanggan() * product.getProductBiayaAdminTutup();
        }
        else if( product.getProductBiayaAdminTutupTipe().trim().equalsIgnoreCase("nominal")){
            biayaTutup = product.getProductBiayaAdminTutup();
        }
        transaksi.setBiayaAdmTutup(biayaTutup);
        transaksi.setTotalPengembalian(totalPinjaman + totalJasaPeny + biayaTutup );
        transaksi.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        
        return transaksi;
    } 
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CicilanTetapEntity tabelCicilan(TrxModel trxModel) throws ClientException{

        return null;
    }
    
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CicilanTetapEntity save(TrxModel trxModel) throws ClientException{
        
        trxValidator.notnullChekcNoTrans(trxModel.getNoTransaksi());
        trxValidator.nullChekcCustId(trxModel.getCustId());
        trxValidator.validateCustId(trxModel.getCustId());

        Long countId = customerRepo.countById((trxModel.getCustId()));
        if(countId<1){
            throw new ClientException("Id customer tidak ditemukan");
  
        }
        else if(countId > 1){
            throw new ClientException("ga mungkin !!!");
        }

        trxValidator.nullChekcNilaicairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        trxValidator.validateNilaicairanPelanggan(trxModel.getNilaiPencairanPelanggan());

        CustomerEntity customer = customerRepo.findById(trxModel.getCustId()).orElse( null);
        if(trxModel.getNilaiPencairanPelanggan() > customer.getCustLimitTxn()){
            throw new ClientException("Nilai Pencairan Pelanggan Harus lebih kecil atau sama dengan limit transaksi pelanggan. "+
            "(limitTrx untuk pelanggan dengan id: " + trxModel.getCustId()+ " adalah " + customer.getCustLimitTxn());
        }

        trxValidator.validateTotalNilaiTaksiran(trxModel.getTotalNilaiTaksiran());
        trxValidator.validateDiskonAdminBuka(trxModel.getDiskonAdmBuka());

       if(trxModel.getDaftarBarangGadai().size()<1){
            throw new ClientException("Barang yang akan di Gadaikan tidak boleh kosong");
       }
       
        for(Integer i = 0; i < trxModel.getDaftarBarangGadai().size(); i++) {
            barangValidator.notNullChekTransId(trxModel.getDaftarBarangGadai().get(i).getNoTransaksi());
            barangValidator.nullCheckBarangName(trxModel.getDaftarBarangGadai().get(i).getNamaBarang());
            barangValidator.validateBarangName(trxModel.getDaftarBarangGadai().get(i).getNamaBarang());
            barangValidator.nullCheckBarangDesc(trxModel.getDaftarBarangGadai().get(i).getKondisi());
            barangValidator.validateBarangDesc(trxModel.getDaftarBarangGadai().get(i).getKondisi());
            barangValidator.nullCheckBarangQuantity(trxModel.getDaftarBarangGadai().get(i).getJumlahBarang());
            barangValidator.validateBarangQuantity(trxModel.getDaftarBarangGadai().get(i).getJumlahBarang());
            barangValidator.nullCheckBarangPrice(trxModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());
            barangValidator.validateBarangPrice(trxModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());

        }

        CicilanTetapEntity cicilanTetap = new CicilanTetapEntity();
        cicilanTetap = count(trxModel);
        cicilanTetap.setCustId(trxModel.getCustId());
        cicilanTetap = cicilanTetapRepo.save(cicilanTetap);
        
        Double totalNilaiTaksiran = 0.00; 
        List<BarangEntity> daftarBarang = new ArrayList<>();
        for(int i = 0; i < trxModel.getDaftarBarangGadai().size(); i++) {
            BarangEntity barang = new BarangEntity();
            barang.setNoUrut(i+1);
            barang.setNoTransaksi(cicilanTetap.getNoTransaksi());
            barang.setNamaBarang(trxModel.getDaftarBarangGadai().get(i).getNamaBarang());
            barang.setKondisiBarang(trxModel.getDaftarBarangGadai().get(i).getKondisi());
            barang.setJmlhBarang(trxModel.getDaftarBarangGadai().get(i).getJumlahBarang());
            barang.setHargaBarang(trxModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());
            totalNilaiTaksiran += (trxModel.getDaftarBarangGadai().get(i).getHargaPerSatuan() * trxModel.getDaftarBarangGadai().get(i).getJumlahBarang());
           
            daftarBarang.add(barang);

        }
        barangRepo.saveAll(daftarBarang);
        cicilanTetap.setTotalNilaiTaksiran(totalNilaiTaksiran);
        cicilanTetap.setDaftarBarang(daftarBarang);

        ProductEntity product = productRepo.findById(trxModel.getProductId()).orElse(null);
        int totalCil = product.getProductJangkaWaktu()/product.getProductBiayaPenyPeriode();
        Double pokok = cicilanTetap.getTotalNilaiPinjaman() / totalCil;
        Double bunga = product.getProductBiayaPeny() *pokok;
        List<CicilanEntity> tabelCicilan = new ArrayList<>();
        for(int i = 0; i <totalCil; i++){
            CicilanEntity cicilan = new CicilanEntity();
            cicilan.setNoTransaksi(cicilanTetap.getNoTransaksi());
            cicilan.setCicilanKe(i+1);
            cicilan.setTxPokok(pokok);
            cicilan.setTxBunga(bunga);
            cicilan.setStatusTrans(GlobalConstant.STATUS_T_AKTIF);
            if(i==0){
                cicilan.setStatusTrans(GlobalConstant.STATUS_AKTIF);
            }
            if (LocalDate.now().isAfter(cicilanTetap.getTanggalTx().plusMonths(i*product.getProductBiayaPenyPeriode()))) {
                cicilan.setStatusTrans(GlobalConstant.STATUS_AKTIF);
            } 
            
            cicilan.setTglAktif(cicilanTetap.getTanggalTx().plusMonths(i*product.getProductBiayaPenyPeriode()) );
            LocalDate tglJthTempo = cicilanTetap.getTanggalTx().plusMonths((i+1)*product.getProductBiayaPenyPeriode()).minusDays(1);
            cicilan.setTglJatuhTempo(tglJthTempo);
            cicilan.setTxrDate(new Timestamp(System.currentTimeMillis()));
            
            tabelCicilan.add(cicilan);
        }
        cicilanRepo.saveAll(tabelCicilan);
       
        
        return cicilanTetapRepo.save(cicilanTetap);
        
    } 
    
    public List<CicilanEntity> checkStatusCicilan() {
        List<CicilanEntity> cicilan = new ArrayList<>();
        cicilanRepo.findAll().forEach(cicilan::add);

        for(Integer i = 0; i < cicilan.size(); i++) {
            if (LocalDate.now().isBefore(cicilan.get(i).getTglAktif())) {
                cicilan.get(i).setStatusTrans(GlobalConstant.STATUS_T_AKTIF);
            } 

            else if (LocalDate.now().isAfter(cicilan.get(i).getTglAktif()) && LocalDate.now().isBefore(cicilan.get(i).getTglJatuhTempo()) ) {
                cicilan.get(i).setStatusTrans(GlobalConstant.STATUS_AKTIF);
            } 

            else if (LocalDate.now().isAfter(cicilan.get(i).getTglAktif()) && LocalDate.now().isAfter(cicilan.get(i).getTglJatuhTempo()) ) {
                cicilan.get(i).setStatusTrans(GlobalConstant.STATUS_TERLAMBAT);
            } 

            else if ( cicilan.get(i).getTglBayar() != null ) {
                cicilan.get(i).setStatusTrans(GlobalConstant.STATUS_LUNAS);
            }

            
        }
        cicilanRepo.saveAll(cicilan);

        return cicilan;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public List<DendaEntity> hitungDenda() {
        List<CicilanEntity> cicilan = new ArrayList<>();
        cicilanRepo.findAll().forEach(cicilan::add);

        for(Integer i = 0; i < cicilan.size(); i++) {
            if (cicilan.get(i).getStatusTrans().equalsIgnoreCase(GlobalConstant.STATUS_TERLAMBAT)) {
                DendaEntity denda = new DendaEntity();
                denda.setNoTransaksi(cicilan.get(i).getNoTransaksi());
                denda.setCicilanKe(cicilan.get(i).getCicilanKe());
                denda.setTglDenda(LocalDate.now());
                denda.setBiayaDenda(cicilan.get(i).getTxPokok() * 0.0123);
                dendaRepo.save(denda);
            }
        }

        return null;
    }


}
