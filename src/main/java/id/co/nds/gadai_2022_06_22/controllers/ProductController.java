package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.ProductService;



@RestController
@RequestMapping("/produk")
public class ProductController {
    @Autowired
    private ProductService productService;

    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel>doInsertProduk(@RequestBody ProductModel productModel){
        try {
            //request
            ProductEntity product = productService.add(productModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Sukses Input Data Produk Baru");
            response.setData(product);
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
    public ResponseEntity<ResponseModel>doGetListProduk(){
        try {
            //request
            List<ProductEntity> products = productService.findAll();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(products);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

    @GetMapping(value = "/get/search")
    public ResponseEntity<ResponseModel>doSearchProduk(@RequestBody ProductModel productModel){
        try {
            //request
            List<ProductEntity> product = productService.findAllByCriteria(productModel);


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


    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseModel>doDetailProduk(@PathVariable String id){
        try {
            //request
            ProductEntity product = productService.findById(id);
            
            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Hasil Pencarian");
            response.setData(product);
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
    public ResponseEntity<ResponseModel>doUpdateProduk(@RequestBody ProductModel productModel){
        try {
            //request
            ProductEntity product = productService.edit(productModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Sukses Ubah data produk");
            response.setData(product);
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

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseModel>doDeleteProduk(@RequestBody ProductModel productModel){
        try {
            //request
            ProductEntity product = productService.delete(productModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "Sukses hapus data produk");
            response.setData(product);
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



