package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.BarangEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.repos.BarangRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.CustomerRepo;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.CustomerSpec;
import id.co.nds.gadai_2022_06_22.repos.specs.ProductSpec;
import id.co.nds.gadai_2022_06_22.repos.specs.TransCicTetapSpec;
import id.co.nds.gadai_2022_06_22.validators.BarangValidator;
import id.co.nds.gadai_2022_06_22.validators.CicilanTetapValidator;
import id.co.nds.gadai_2022_06_22.validators.CustomerValidator;
import id.co.nds.gadai_2022_06_22.validators.ProductValidator;

@Service
public class TransactionService implements Serializable{
    @Autowired
    private CicilanTetapRepo cicilanTetapRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private BarangRepo barangRepo;

    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private ProductRepo productRepo;

    CicilanTetapValidator cicilanTetapValidator = new CicilanTetapValidator();
    CustomerValidator customerValidator = new CustomerValidator();
    ProductValidator productValidator = new ProductValidator();
    BarangValidator barangValidator = new BarangValidator();

    public List<CicilanTetapEntity> doSearchTransCicTetap(CicilanTetapModel cicilanTetapModel) {
        List<CicilanTetapEntity> transCicTetap = new ArrayList<>();
        TransCicTetapSpec transCicTetapSpec = new TransCicTetapSpec(cicilanTetapModel);
        cicilanTetapRepo.findAll(transCicTetapSpec).forEach(transCicTetap::add);
        return transCicTetap;
    }

    public CicilanTetapEntity doGetDetailCicTetap(String noTransaksi) throws ClientException, NotFoundException{
        cicilanTetapValidator.nullCheckTransaksiNo(noTransaksi);
        cicilanTetapValidator.validateTransaksiNo(noTransaksi);


        CicilanTetapEntity transaksi = cicilanTetapRepo.findById(noTransaksi).orElse(null);
        cicilanTetapValidator.nullCheckObject(transaksi);

        return transaksi;
    }

    public List<CustomerEntity> doSearchPelanggan(CustomerModel customerModel) {
        List<CustomerEntity> customer = new ArrayList<>();
        CustomerSpec specs = new CustomerSpec(customerModel);
        customerRepo.findAll(specs).forEach(customer::add);
        ArrayList response = new ArrayList<>();
        for (CustomerEntity customerEntity : customer) {
            response.add("custId: " + customer.get(0).getCustId());
            response.add("custKtp: " + customer.get(0).getCustKtp());
            response.add("custHp: " + customer.get(0).getCustHp());
            response.add("custName: " + customer.get(0).getCustName());
        }

        return response;
    }

    public List<ProductEntity> doGetListProduk(ProductModel productModel) {
        List<ProductEntity> product = new ArrayList<>();
        ProductSpec specs = new ProductSpec(productModel);
        productRepo.findAll(specs).forEach(product::add);
        ArrayList response = new ArrayList<>();
        for (ProductEntity productEntity : product) {
            response.add("productId: " + product.get(0).getProductId());
            response.add("productName: " + product.get(0).getProductName());
            response.add("productDesc: " + product.get(0).getProductDesc());
        }

        return response;
    }

    public CicilanTetapEntity doHitungTrxCicTetap(CicilanTetapModel cicilanTetapModel) throws ClientException {
        customerValidator.nullCheckCustLimitTxn(cicilanTetapModel.getNilaiPencairanPelanggan());
        customerValidator.validatetLimitTxn(cicilanTetapModel.getNilaiPencairanPelanggan());

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public CicilanTetapEntity doSaveTrxCicTetap(CicilanTetapModel cicilanTetapModel) throws ClientException, NotFoundException {
        customerValidator.nullCheckCustId(cicilanTetapModel.getCustId());
        customerValidator.validateCustId(cicilanTetapModel.getCustId());

        productValidator.nullCheckProductId(cicilanTetapModel.getProductId());
        productValidator.validateProductId(cicilanTetapModel.getProductId());

        ProductEntity product = new ProductEntity();
        product = productService.doGetDetailProduct(cicilanTetapModel.getProductId());

        cicilanTetapValidator.nullChecNilaiPencairanPelanggan(cicilanTetapModel.getNilaiPencairanPelanggan());
        cicilanTetapValidator.validateNilaiPencairanPelanggan(cicilanTetapModel.getNilaiPencairanPelanggan());
        cicilanTetapValidator.nullCheckDiskonAdmBuka(cicilanTetapModel.getDiskonAdmBuka());
        cicilanTetapValidator.validateDiskonAdmBuka(cicilanTetapModel.getDiskonAdmBuka());

       

        CicilanTetapEntity cicilanTetap = new CicilanTetapEntity();
        cicilanTetap.setCustId(cicilanTetapModel.getCustId());
        cicilanTetap.setProductId(cicilanTetapModel.getProductId());
        cicilanTetap.setNilaiPencairanPelanggan(cicilanTetapModel.getNilaiPencairanPelanggan());
        cicilanTetap.setDiskonAdmBuka(cicilanTetapModel.getDiskonAdmBuka());
        cicilanTetap.setTxLtv(product.getProductLtv());
        cicilanTetap.setBiayaAdmBuka(product.getProductAdminOpeningFee());
        cicilanTetap.setBiayaAdmBukaAkhir(product.getProductAdminOpeningFee() - (product.getProductAdminOpeningFee() * cicilanTetapModel.getDiskonAdmBuka() / 100));
        cicilanTetap.setTotalNilaiPinj(cicilanTetapModel.getNilaiPencairanPelanggan() + (product.getProductAdminOpeningFee() - (product.getProductAdminOpeningFee() * cicilanTetapModel.getDiskonAdmBuka() / 100)));
        cicilanTetap.setTglTx(new Timestamp(System.currentTimeMillis()));
        cicilanTetap.setTglJatuhTempo(Timestamp.valueOf(LocalDateTime.now().plusMonths(product.getProductJangkaWaktu())));
        cicilanTetap.setTxBiayaJasaPeny(product.getProductBiayaJasaPeny());
        cicilanTetap.setTxBiayaJasaPenyPer(product.getProductBiayaJasaPenyPeriode());
        cicilanTetap.setTotalBiayaJasaPeny(product.getProductJangkaWaktu() / product.getProductBiayaJasaPenyPeriode() * product.getProductBiayaJasaPenyPeriode().doubleValue());
        cicilanTetap.setTxBiayaAdmTutup(product.getProductAdminClosingFee());
        cicilanTetap.setTotalPengem(cicilanTetapModel.getNilaiPencairanPelanggan() + (product.getProductAdminOpeningFee() - (product.getProductAdminOpeningFee() * cicilanTetapModel.getDiskonAdmBuka() / 100))
         + product.getProductJangkaWaktu() / product.getProductBiayaJasaPenyPeriode() * product.getProductBiayaJasaPenyPeriode().doubleValue() 
         + product.getProductAdminClosingFee());

        cicilanTetap.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        cicilanTetapRepo.save(cicilanTetap);
         
        Double totalNilaiTak = (double) 0;
        List<BarangEntity> daftarBarang = new ArrayList<>();
        Integer jumlahBarang = cicilanTetapModel.getDaftarBarangGadai().size();
        for(Integer i = 0; i < jumlahBarang; i++) {
           barangValidator.nullCheckProductName(cicilanTetapModel.getDaftarBarangGadai().get(i).getNamaBarang());
           barangValidator.validateProductName(cicilanTetapModel.getDaftarBarangGadai().get(i).getNamaBarang());
           barangValidator.nullCheckProductCondition(cicilanTetapModel.getDaftarBarangGadai().get(i).getKondisi());
           barangValidator.validateProductCondition(cicilanTetapModel.getDaftarBarangGadai().get(i).getKondisi());
           barangValidator.nullCheckProductQuantity(cicilanTetapModel.getDaftarBarangGadai().get(i).getJumlah());
           barangValidator.validateProductQuantity(cicilanTetapModel.getDaftarBarangGadai().get(i).getJumlah());
           barangValidator.nullCheckProductPrice(cicilanTetapModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());
           barangValidator.validateProductPrice(cicilanTetapModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());
           
           BarangEntity barang = new BarangEntity();
           barang.setNoUrut(i+1);
           barang.setNamaBarang(cicilanTetapModel.getDaftarBarangGadai().get(i).getNamaBarang());
           barang.setKondisi(cicilanTetapModel.getDaftarBarangGadai().get(i).getKondisi());
           barang.setJumlah(cicilanTetapModel.getDaftarBarangGadai().get(i).getJumlah());
           barang.setHargaPerSatuan(cicilanTetapModel.getDaftarBarangGadai().get(i).getHargaPerSatuan());
           barang.setNoTransaksi(cicilanTetap.getNoTransaksi());
           
           totalNilaiTak = totalNilaiTak + ((cicilanTetapModel.getDaftarBarangGadai().get(i).getHargaPerSatuan() * cicilanTetapModel.getDaftarBarangGadai().get(i).getJumlah()));
           barangRepo.save(barang);
           daftarBarang.add(barang);
        }
        cicilanTetap.setTotalNilaiTak(totalNilaiTak);
        cicilanTetap.setMaxNilaiPinj(totalNilaiTak * cicilanTetap.getTxLtv());

        cicilanTetap.setDaftarBarang(daftarBarang);

        return cicilanTetapRepo.save(cicilanTetap);
    }

}
