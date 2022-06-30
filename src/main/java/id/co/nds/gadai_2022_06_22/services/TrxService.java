package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.BarangEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.models.TrxModel;
import id.co.nds.gadai_2022_06_22.repos.BarangRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.CustomerRepo;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.TrxSpec;
import id.co.nds.gadai_2022_06_22.repos.specs.CustomerSpec;
import id.co.nds.gadai_2022_06_22.repos.specs.ProductSpec;
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
    private ProductService productService;

    @Autowired
    private BarangRepo barangRepo;

   
    CustomerValidator customerValidator = new CustomerValidator();
    ProductValidator productValidator = new ProductValidator();
    BarangValidator barangValidator = new BarangValidator();
    TrxValidator trxValidator = new TrxValidator();  

    

    public List<CicilanTetapEntity> findTrxByCriteria(TrxModel trxModel){
        List<CicilanTetapEntity> cicilan = new ArrayList<>();
        TrxSpec trxSpec = new TrxSpec(trxModel);
        cicilanTetapRepo.findAll(trxSpec).forEach(cicilan::add);
        return cicilan;
    }

    public List<CicilanTetapEntity> findByNoTrans(String nomor) throws ClientException, NotFoundException{
        
        trxValidator.nullChekcNoTrans(nomor);
        trxValidator.validateNoTrans(nomor);
        CicilanTetapEntity trx = cicilanTetapRepo.findById(nomor).orElse( null);
        CustomerEntity customer = customerRepo.findById(trx.getCustId()).orElse( null);
        ProductEntity product = productRepo.findById(trx.getProductId()).orElse( null);
        List<BarangEntity> barang = new ArrayList<>();
        barangRepo.findBarangByNoTrx(nomor).forEach(barang::add);
       
        trxValidator.nullChekcObject(nomor);
        ArrayList param = new ArrayList();
       
        param.add("custId: " + trx.getCustId());
        param.add("custName: " + customer.getCustName());
        param.add("productId: " + trx.getProductId());
        param.add("trxDate: " + trx.getTanggalTx());
        param.add("productName: " + product.getProductName());
        param.add("productDesc: " + product.getProductDesc());
        param.add("daftarBarangGadai: "  );
        for (int i=0; i<barang.size();i++){
            param.add("               " + barang.get(i));
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

    public CicilanTetapEntity count(TrxModel trxModel) throws ClientException{
        trxValidator.nullChekcProductId(trxModel.getProductId());
        trxValidator.validateProductId(trxModel.getProductId());
        trxValidator.nullChekcNilaicairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        trxValidator.validateNilaicairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        trxValidator.nullChekcTotalNilaiTaksiran(trxModel.getTotalNilaiTaksiran());
        trxValidator.validateTotalNilaiTaksiran(trxModel.getTotalNilaiTaksiran());

        ProductEntity product = productRepo.findById(trxModel.getProductId()).orElse( null);
        CicilanTetapEntity transaksi =new CicilanTetapEntity();

        if (trxModel.getDiskonAdmBuka()==null){
            transaksi.setBiayaAdmBuka(0.00);
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
        transaksi.setBiayaAdmTutup(biayaBuka);
        
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
       

        return transaksi;
    } 
    

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CicilanTetapEntity save(TrxModel trxModel) throws ClientException{
        
        trxValidator.notnullChekcNoTrans(trxModel.getNoTransaksi());
        trxValidator.nullChekcProductId(trxModel.getProductId());
        trxValidator.validateProductId(trxModel.getProductId());

        Long count = productRepo.countProductIdCiTetap((trxModel.getProductId()));
        if(count<1){
            throw new ClientException("Id product tidak ditemukan");
  
        } 
        else if(count > 1){
            throw new ClientException("ga mungkin");
        }
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
        trxValidator.validateTotalNilaiTaksiran(trxModel.getTotalNilaiTaksiran());
        trxValidator.validateDiskonAdminBuka(trxModel.getDiskonAdmBuka());

        Double totalNilaiTaksiran = 0.00; 
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

            totalNilaiTaksiran += (trxModel.getDaftarBarangGadai().get(i).getHargaPerSatuan() * trxModel.getDaftarBarangGadai().get(i).getJumlahBarang());

        }

        CicilanTetapEntity cicilanTetap = new CicilanTetapEntity();
        cicilanTetap.setCustId(trxModel.getCustId());
        cicilanTetap.setProductId(trxModel.getProductId());
        cicilanTetapRepo.save(cicilanTetap);
                
        List<BarangEntity> daftarBarang = new ArrayList<>();
        for(int i = 0; i < trxModel.getDaftarBarangGadai().size(); i++) {
            BarangEntity barang = new BarangEntity();
            barang.setNoUrut(i+1);
            barang.setNoTransaksi(cicilanTetap.getNoTransaksi());
            barang.setNamaBarang(trxModel.getDaftarBarangGadai().get(i).getNamaBarang());
            barang.setKondisiBarang(trxModel.getDaftarBarangGadai().get(i).getKondisi());
            barang.setJmlhBarang(trxModel.getDaftarBarangGadai().get(i).getJumlahBarang());
            barang.setHargaBarang(trxModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());
            
           
            daftarBarang.add(barang);
            

        }
        cicilanTetap.setNilaiPencairanPelanggan(trxModel.getNilaiPencairanPelanggan());
        cicilanTetap.setDiskonAdmBuka(trxModel.getDiskonAdmBuka());
        cicilanTetap.setTotalNilaiTaksiran(totalNilaiTaksiran);
        cicilanTetap.setDaftarBarang(daftarBarang);
        barangRepo.saveAll(daftarBarang);

        cicilanTetap = count(trxModel);
        
        return cicilanTetapRepo.save(cicilanTetap);
        
    } 

    

}
