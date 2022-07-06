package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.PaymentModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.PaymentService;

@RestController
@RequestMapping("/bayar")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/get/search")
    public ResponseEntity<ResponseModel>doSearchBayarCicTetap(@RequestBody PaymentModel paymentModel){
        try {
            //request
            List<CicilanTetapEntity> pay = paymentService.findPaymentByCriteria(paymentModel);


            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(pay);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseModel>doGetDetailTagihanCic(@PathVariable String id){
        try {
            //request
            List<CicilanTetapEntity> pay = paymentService.findByNoTrans(id);
            
            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(pay);
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
    
    @PutMapping(value = "/update")
    public ResponseEntity<ResponseModel>doUpdatePembayaran(@RequestBody PaymentModel paymentModel){
        try {
            //request
            CicilanTetapEntity pay = paymentService.edit(paymentModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Sukses Ubah data pelanggan");
            response.setData(pay);
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

    
}

