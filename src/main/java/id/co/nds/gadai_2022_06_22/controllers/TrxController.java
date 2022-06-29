package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.TrxModel;
import id.co.nds.gadai_2022_06_22.services.TrxService;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;


@RestController
@RequestMapping("/cicilan")
public class TrxController {
    @Autowired
    private TrxService trxService;

    
    // @PostMapping(value = "/add")
    // public ResponseEntity<ResponseModel>doSaveTrxCicTetap(@RequestBody TrxModel trxModel){
    //     try {
    //         //request
    //         CicilanTetapEntity cicilan = trxService.add(trxModel);

    //         //response
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg( "Sukses Input Data Cicilan Baru");
    //         response.setData(cicilan);
    //         return ResponseEntity.ok(response);

    //     } catch(ClientException e){
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg(e.getMessage());
    //         return ResponseEntity.badRequest().body(response);
    //     }catch(Exception e){
    //         ResponseModel response =new ResponseModel();
    //         response.setMsg("Terjadi Kesahalan Pada Server");
    //         e.printStackTrace();
    //         return ResponseEntity.internalServerError().body(response);
    //     }
    // } 
 

    @GetMapping(value = "/get/search")
    public ResponseEntity<ResponseModel>doSearchTransCicTetap(@RequestBody TrxModel trxModel){
        try {
            //request
            List<CicilanTetapEntity> cicilan = trxService.findTrxByCriteria(trxModel);


            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(cicilan);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseModel>doGetDetailCicTetap(@RequestBody String id)throws ClientException, NotFoundException {
        try {
            //request
            CicilanTetapEntity cicilan = trxService.findByNoTrans(id);
            
            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(cicilan);
            return ResponseEntity.ok(response);

        } catch(ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch(NotFoundException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

    @GetMapping(value = "/get/pelanggan")
    public ResponseEntity<ResponseModel>doSearchPelanggan(@RequestBody CustomerModel customerModel){
        try {
            //request
            List<CustomerEntity> customer = trxService.findCustomerByCriteria(customerModel);


            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(customer);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

    @GetMapping(value = "/get/produk")
    public ResponseEntity<ResponseModel>doGetListProduk(@RequestBody ProductModel productModel) {
        try {
            //request
            List<ProductEntity> product = trxService.findAllProduct(productModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(product);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 


    // @PostMapping(value = "/count")
    // public ResponseEntity<ResponseModel>doHitungTrxCicTetap(@RequestBody TrxModel trxModel){
    //     try {
    //         //request
    //         CicilanTetapEntity trx = trxService.count(trxModel);

    //         //response
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg( "Sukses Input Data Cicilan Baru");
    //         response.setData(trx);
    //         return ResponseEntity.ok(response);

    //     } catch(ClientException e){
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg(e.getMessage());
    //         return ResponseEntity.badRequest().body(response);
    //     }catch(Exception e){
    //         ResponseModel response =new ResponseModel();
    //         response.setMsg("Terjadi Kesahalan Pada Server");
    //         e.printStackTrace();
    //         return ResponseEntity.internalServerError().body(response);
    //     }
    // } 


}
