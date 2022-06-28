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
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.CicilanService;

@RestController
@RequestMapping("/cicilan")
public class CicilanController {
    @Autowired
    private CicilanService cicilanService;

    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel>doSaveTrxCicTetap(@RequestBody CicilanModel cicilanModel){
        try {
            //request
            CicilanEntity cicilan = cicilanService.add(cicilanModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Sukses Input Data Cicilan Baru");
            response.setData(cicilan);
            return ResponseEntity.ok(response);

        } catch(ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 
 
    @GetMapping(value = "/get")
    public ResponseEntity<ResponseModel>doGetListCicilan(){
        try {
            //request
            List<CicilanEntity> cicilans = cicilanService.findAll();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(cicilans);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

    // @GetMapping(value = "/get/search")
    // public ResponseEntity<ResponseModel>doSearchTransCicTetap(@RequestBody CicilanModel cicilanModel){
    //     try {
    //         //request
    //         List<CicilanEntity> cicilan = cicilanService.findAllByCriteria(cicilanModel);


    //         //response
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg( "Hasil Pencarian");
    //         response.setData(cicilan);
    //         return ResponseEntity.ok(response);

        
    //     }catch(Exception e){
    //         ResponseModel response =new ResponseModel();
    //         response.setMsg("Terjadi Kesahalan Pada Server");
    //         e.printStackTrace();
    //         return ResponseEntity.internalServerError().body(response);
    //     }
    // } 


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseModel>doGetDetailCicTetap(@PathVariable String id){
        try {
            //request
            CicilanEntity cicilan = cicilanService.findById(id);
            
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

    // @GetMapping(value = "/get/pelanggan/search")
    // public ResponseEntity<ResponseModel>doSearchPelanggan(@RequestBody CicilanModel cicilanModel){
    //     try {
    //         //request
    //         List<CicilanEntity> cicilan = cicilanService.findCustomerByCriteria(cicilanModel);


    //         //response
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg( "Hasil Pencarian");
    //         response.setData(cicilan);
    //         return ResponseEntity.ok(response);

        
    //     }catch(Exception e){
    //         ResponseModel response =new ResponseModel();
    //         response.setMsg("Terjadi Kesahalan Pada Server");
    //         e.printStackTrace();
    //         return ResponseEntity.internalServerError().body(response);
    //     }
    // } 

    // @GetMapping(value = "/get/produk")
    // public ResponseEntity<ResponseModel>doGetListProduk(){
    //     try {
    //         //request
    //         List<CicilanEntity> cicilan = cicilanService.findAllProduct();

    //         //response
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg( "Hasil Pencarian");
    //         response.setData(cicilan);
    //         return ResponseEntity.ok(response);

        
    //     }catch(Exception e){
    //         ResponseModel response =new ResponseModel();
    //         response.setMsg("Terjadi Kesahalan Pada Server");
    //         e.printStackTrace();
    //         return ResponseEntity.internalServerError().body(response);
    //     }
    // } 


    
   

}
