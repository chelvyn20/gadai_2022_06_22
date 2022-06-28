package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.ProductSpec;
import id.co.nds.gadai_2022_06_22.validators.ProductValidator;

@Service
public class ProductService implements Serializable {
    @Autowired
    private ProductRepo productRepo;

    ProductValidator productValidator = new ProductValidator();
    

    public ProductEntity add(ProductModel productModel) throws ClientException{
        productValidator.nullChekcProductTipe(productModel.getProductTipe());
        productValidator.validateProductTipe(productModel.getProductTipe());
        productValidator.notnullChekcProductId(productModel.getProductId());
        productValidator.nullChekcProductName(productModel.getProductName());
        productValidator.validateName(productModel.getProductName());
        productValidator.nullChekcProductJangkaWaktu(productModel.getProductJangkaWaktu());
        productValidator.validateProductJangkaWaktu(productModel.getProductTipe(),productModel.getProductJangkaWaktu());
        productValidator.nullChekcProductLtv(productModel.getProductLtv());
        productValidator.validateProductLtv(productModel.getProductLtv());
        productValidator.nullChekcBiayaAdminBukaTipe(productModel.getProductBiayaAdminBukaTipe());
        productValidator.validateBiayaAdminBukaTipe(productModel.getProductBiayaAdminBukaTipe());
        productValidator.nullChekcBiayaAdminBuka(productModel.getProductBiayaAdminBuka());
        productValidator.validateBiayaAdminBuka(productModel.getProductBiayaAdminBukaTipe(), productModel.getProductBiayaAdminBuka());
        productValidator.nullChekcBiayaAdminTutupTipe(productModel.getProductBiayaAdminTutupTipe());
        productValidator.validateBiayaAdminTutupTipe(productModel.getProductBiayaAdminTutupTipe());
        productValidator.nullChekcBiayaAdminTutup(productModel.getProductBiayaAdminTutup());
        productValidator.validateBiayaAdminTutup(productModel.getProductBiayaAdminTutupTipe(), productModel.getProductBiayaAdminTutup());
        productValidator.nullChekcBiayaAdminPeny(productModel.getProductBiayaPeny());
        productValidator.validateBiayaAdminPeny(productModel.getProductBiayaPeny());
        productValidator.nullChekcBiayaAdminPenyPeriode(productModel.getProductBiayaPenyPeriode());
        productValidator.validateBiayaAdminPenyPeriode(productModel.getProductJangkaWaktu(), productModel.getProductBiayaPenyPeriode());
        productValidator.nullChekcBiayaAdminDenda(productModel.getProductBiayaDenda());
        productValidator.validateBiayaAdminDenda(productModel.getProductBiayaDenda());
        productValidator.nullChekcBiayaAdminDendaPeriode(productModel.getProductBiayaDendaPeriode());
        productValidator.validateBiayaAdminDendaPeriode(productModel.getProductBiayaDendaPeriode());

        if(productModel.getProductDesc()!=null){

            productValidator.validateProductDesc(productModel.getProductDesc());
        }
       


        Long count = productRepo.countById((productModel.getProductId()));
        if(count>0){
            throw new ClientException("Id product sudah digunakan");
  
        }     

        ProductEntity product =new ProductEntity();
        product.setProductTipe(productModel.getProductTipe());
        product.setProductId(productModel.getProductId());
        product.setProductName(productModel.getProductName());
        product.setProductJangkaWaktu(productModel.getProductJangkaWaktu());
        product.setProductLtv(productModel.getProductLtv());
        product.setProductBiayaAdminBuka(productModel.getProductBiayaAdminBuka());
        product.setProductBiayaAdminBukaTipe(productModel.getProductBiayaAdminBukaTipe());
        product.setProductBiayaAdminTutup(productModel.getProductBiayaAdminTutup());
        product.setProductBiayaAdminTutupTipe(productModel.getProductBiayaAdminTutupTipe());
        product.setProductBiayaPeny(productModel.getProductBiayaPeny());
        product.setProductBiayaPenyPeriode(productModel.getProductBiayaPenyPeriode());
        product.setProductBiayaDenda(productModel.getProductBiayaDenda());
        product.setProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());
        product.setProductStatus(GlobalConstant.REC_STATUS_ACTIVE);
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setCreatorId(productModel.getActorId()==null ?0: productModel.getActorId());
        product.setProductDesc(productModel.getProductDesc());

        

        return productRepo.save(product);
    } 
    
    public List<ProductEntity> findAll(){
        List<ProductEntity> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        return products;
    }
    
    public List<ProductEntity> findAllByCriteria(ProductModel productModel){
        List<ProductEntity> products = new ArrayList<>();
        ProductSpec productSpec = new ProductSpec(productModel);
        productRepo.findAll(productSpec).forEach(products::add);
        return products;
    }
    
    public ProductEntity findById(String id) throws ClientException, NotFoundException{
        productValidator.nullChekcProductId((id));
        productValidator.validateProductId(id);

        ProductEntity product = productRepo.findById(id).orElse( null);
        productValidator.nullChekcObject(product);
        productValidator.validateProductStatus(id, product.getProductStatus());
        return product;
    }
    
    public ProductEntity edit (ProductModel productModel)
    throws ClientException,NotFoundException{
       //validation
       productValidator.nullChekcProductId(productModel.getProductId());
       productValidator.validateProductId(productModel.getProductId());
       
       if(!productRepo.existsById(productModel.getProductId())){
           throw new NotFoundException( "Id Produk Tidak Ditemukan");
       }

       //proses
       ProductEntity product = new ProductEntity();
       
       product=findById(productModel.getProductId());
       productValidator.validateProductStatus(product.getProductId(), product.getProductStatus());

       if(productModel.getProductTipe() !=null){
        productValidator.validateProductTipe( productModel.getProductTipe());
        product.setProductTipe(productModel.getProductTipe());
        }

       if(productModel.getProductName() !=null){
           productValidator.validateName( productModel.getProductName());
           product.setProductName(productModel.getProductName());
       }

       if(productModel.getProductJangkaWaktu() !=null){
           productValidator.validateProductJangkaWaktu( productModel.getProductTipe(), productModel.getProductJangkaWaktu());
           product.setProductJangkaWaktu(productModel.getProductJangkaWaktu());
       }

       if(productModel.getProductLtv() !=null){
           productValidator.validateProductLtv(productModel.getProductLtv());
           product.setProductLtv(productModel.getProductLtv());
       }

       if(productModel.getProductBiayaAdminBukaTipe() !=null){
           productValidator.validateBiayaAdminBukaTipe( productModel.getProductBiayaAdminBukaTipe());
           product.setProductBiayaAdminBukaTipe(productModel.getProductBiayaAdminBukaTipe());
       }

       if(productModel.getProductBiayaAdminBuka() !=null){
        productValidator.validateBiayaAdminBuka(productModel.getProductBiayaAdminBukaTipe(), (productModel.getProductBiayaAdminBuka()));
        product.setProductBiayaAdminBuka(productModel.getProductBiayaAdminBuka());
        }

        if(productModel.getProductBiayaAdminTutupTipe() !=null){
            productValidator.validateBiayaAdminTutupTipe( productModel.getProductBiayaAdminTutupTipe());
            product.setProductBiayaAdminTutupTipe(productModel.getProductBiayaAdminTutupTipe());
        }

       if(productModel.getProductBiayaAdminTutup() !=null){
           productValidator.validateBiayaAdminTutup(productModel.getProductBiayaAdminTutupTipe(), productModel.getProductBiayaAdminTutup());
           product.setProductBiayaAdminTutup(productModel.getProductBiayaAdminTutup());
       }


       if(productModel.getProductBiayaPeny() !=null){
           productValidator.validateBiayaAdminPeny(productModel.getProductBiayaPeny());
           product.setProductBiayaPeny(productModel.getProductBiayaPeny());
       }

       if(productModel.getProductBiayaPenyPeriode() !=null){
           productValidator.validateBiayaAdminPenyPeriode(productModel.getProductJangkaWaktu(), productModel.getProductBiayaPenyPeriode());
           product.setProductBiayaPenyPeriode(productModel.getProductBiayaPenyPeriode());
       }

       if(productModel.getProductBiayaDenda() !=null){
           productValidator.validateBiayaAdminDenda( productModel.getProductBiayaDenda());
           product.setProductBiayaDenda(productModel.getProductBiayaDenda());
       }

       if(productModel.getProductBiayaDendaPeriode() !=null){
           productValidator.validateBiayaAdminDendaPeriode(productModel.getProductBiayaDendaPeriode());
           product.setProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());
       }
       if(productModel.getProductDesc() !=null){
        productValidator.validateProductDesc(productModel.getProductDesc());
        product.setProductDesc(productModel.getProductDesc());
        }

       product.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
       product.setUpdaterId(productModel.getActorId() == null ? 0 :productModel.getActorId());

       return productRepo.save(product);
    }

    public ProductEntity delete (ProductModel productModel) throws ClientException, NotFoundException{
        //validation
        productValidator.nullChekcProductId(productModel.getProductId());
        productValidator.validateProductId(productModel.getProductId());
        
        if(!productRepo.existsById((productModel.getProductId()))){
            throw new NotFoundException( " Id produk tidak ditemukan ");
        }
        //proses
        ProductEntity product = new ProductEntity();
       
        product=findById(productModel.getProductId());
        productValidator.validateProductStatus(product.getProductId(), product.getProductStatus());

        if(product.getProductStatus().equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE)){
            throw new ClientException("Sukses hapus data produk (" + productModel.getProductId() );
        }
        product.setProductStatus(GlobalConstant.REC_STATUS_NONACTIVE);
        product.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        product.setDeleterId(productModel.getActorId() == null ? 0 :productModel.getActorId());

        return productRepo.save(product);
    }
}

    
   



    
   
