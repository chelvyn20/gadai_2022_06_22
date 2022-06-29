package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public CicilanTetapEntity findByNoTrans(String nomor) throws ClientException, NotFoundException{
        
        trxValidator.nullChekcNoTrans(nomor);
        trxValidator.validateNoTrans(nomor);

        CicilanTetapEntity trx = cicilanTetapRepo.findById(nomor).orElse( null);
        trxValidator.nullChekcObject(nomor);
        // trxValidator.validateTransStatus(nomor, cicilan.getStatusTrans());
        return trx;
    }

    public List<CustomerEntity> findCustomerByCriteria(CustomerModel customerModel){
        List<CustomerEntity> customers = new ArrayList<>();
        CustomerSpec customerSpec = new CustomerSpec(customerModel);
        customerRepo.findAll(customerSpec).forEach(customers::add);
        ArrayList param = new ArrayList();
        for(CustomerEntity customerEntity : customers){
            param.add("custId: " + customers.get(0).getCustId());
            param.add("custKtp: " + customers.get(0).getCustKtp());
            param.add("custHp: " + customers.get(0).getCustHp());
            param.add("custName: " + customers.get(0).getCustName());
        }
        return customers;
    }

  
    public List<ProductEntity> findAllProduct(ProductModel productModel) {
        List<ProductEntity> product = new ArrayList<>();
        ProductSpec specs = new ProductSpec(productModel);
        productRepo.findAll(specs).forEach(product::add);
        ArrayList param = new ArrayList<>();
        for (ProductEntity productEntity : product) {
            param.add("productId: " + product.get(0).getProductId());
            param.add("productName: " + product.get(0).getProductName());
            param.add("productDesc: " + product.get(0).getProductDesc());
        }

        return param;
    }


    // public CicilanEntity add(TrxModel cicilanModel) throws ClientException{
        
    //     trxValidator.notnullChekcNoTrans(cicilanModel.getNoTransaksi());
    //     trxValidator.validateNoTrans(cicilanModel.getNoTransaksi());
    //     trxValidator.nullChekcProductId(cicilanModel.getProductId());
    //     trxValidator.validateProductId(cicilanModel.getProductId());
    //     trxValidator.nullChekcCustId(cicilanModel.getCustId());
    //     trxValidator.validateCustId(cicilanModel.getCustId());
    //     trxValidator.nullChekcNilaicairanPelanggan(cicilanModel.getNilaiPencairanPelanggan());
    //     trxValidator.validateNilaicairanPelanggan(cicilanModel.getNilaiPencairanPelanggan());



    //     // if(!productRepo.existsById(cicilanModel.getProductId())) ){
    //     //     throw new NotFoundException( "Cannot find category with id: " +categoryModel.getId());
    //     // }
        

       
    //     CicilanTetapEntity cicilan =new CicilanTetapEntity();
    //     cicilan.setProductId(cicilanModel.getProductId());
    //     cicilan.setCustId(cicilanModel.getCustId());
    //     cicilan.setNilaiPencairanPelanggan(cicilanModel.getNilaiPencairanPelanggan());
    //     cicilan.setTotalNilaiTaksiran(cicilanModel.getTotalNilaiTaksiran());
    //     cicilan.setDiskonAmdBuka(cicilanModel.getDiskonAdmBuka());
        
    //     return cicilanRepo.save(cicilan);
    // } 

    // public CicilanEntity count(TrxModel cicilanModel) throws ClientException{
    //     trxValidator.nullChekcProductId(cicilanModel.getProductId());
    //     trxValidator.validateProductId(cicilanModel.getProductId());
    //     trxValidator.nullChekcNilaicairanPelanggan(cicilanModel.getNilaiPencairanPelanggan());
    //     trxValidator.validateNilaicairanPelanggan(cicilanModel.getNilaiPencairanPelanggan());
    //     trxValidator.validateTotalNilaiTaksiran(cicilanModel.getTotalNilaiTaksiran());
    //     trxValidator.validateDiskonAdminBuka(cicilanModel.getDiskonAdmBuka());

       
    //     CicilanTetapEntity transaksi =new CicilanTetapEntity();

    //     transaksi.setTotalNilaiTaksiran(cicilanModel.getTotalNilaiTaksiran());
       

    //     return cicilanRepo.save(transaksi);
    // } 
    
    

}
