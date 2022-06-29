package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> doInsert(@RequestBody ProductModel productModel) throws ClientException {
        try {
            ProductEntity product = productService.doInsertProduk(productModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Input Data Produk Baru.");
            response.setData(product);
            return ResponseEntity.ok(response);
        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());

            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ResponseModel> doUpdate(@RequestBody ProductModel productModel) throws ClientException, NotFoundException{
        try {
            ProductEntity product = productService.doUpdateProduk(productModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Update Data Produk Baru.");
            response.setData(product);
            return ResponseEntity.ok(response);
        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());

            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseModel> doDelete(@RequestBody ProductModel productModel) throws ClientException, NotFoundException{
        try {
            ProductEntity product = productService.doDeleteProduct(productModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Menghapus Data Produk");
            response.setData(product);
            return ResponseEntity.ok(response);
        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());

            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get/all")
    public ResponseEntity<ResponseModel> doSearchproduct(ProductModel productModel) {
        try {
            List<ProductEntity> product = productService.doSearchProduct(productModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Data produk:");
            response.setData(product);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseModel> doGetDetailproduct(@RequestParam String id) throws ClientException, NotFoundException{
        try {
            ProductEntity product = productService.doGetDetailProduct(id);

            ResponseModel response = new ResponseModel();
            response.setMsg("Produk ditemukan");
            response.setData(product);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }
}
