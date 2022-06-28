package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.ProductService;
import id.co.nds.gadai_2022_06_22.services.TransactionService;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @Autowired
    ProductService productService;

    public ResponseEntity<ResponseModel> doSearchTransCicTetap(@RequestBody CustomerModel customerModel) {
        try {

            ResponseModel response = new ResponseModel();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get/customer")
    public ResponseEntity<ResponseModel> doSearchPelanggan(@RequestBody CustomerModel customerModel) {
        try {
            List<CustomerEntity> customer = transactionService.doSearchPelanggan(customerModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Data customer:");
            response.setData(customer);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    public ResponseEntity<ResponseModel> doGetListProduk(@RequestParam Integer productId) {
        try {
            ProductEntity product = productService.doGetDetailProduct(productId);

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
