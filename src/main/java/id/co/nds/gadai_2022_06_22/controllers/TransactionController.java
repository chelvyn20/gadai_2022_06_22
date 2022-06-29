package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
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

    @GetMapping(value = "/search/transcictetap")
    public ResponseEntity<ResponseModel> doSearchTransCicTetap(@RequestBody CicilanTetapModel cicilanTetapModel) {
        try {
            List<CicilanTetapEntity> transCicTetap = transactionService.doSearchTransCicTetap(cicilanTetapModel);
            ResponseModel response = new ResponseModel();
            response.setMsg("Data Transaksi Cicilan Tetap:");
            response.setData(transCicTetap);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get/detailcictetap")
    public ResponseEntity<ResponseModel> doGetDetailCicTetap(@RequestBody String noTransaksi) throws ClientException, NotFoundException {
        try {
            CicilanTetapEntity transCicTetap = transactionService.doGetDetailCicTetap(noTransaksi);
            ResponseModel response = new ResponseModel();
            response.setMsg("Detail Transaksi Cicilan Tetap:");
            response.setData(transCicTetap);
            return ResponseEntity.ok(response);
        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());

            return ResponseEntity.badRequest().body(response);
        } catch(NotFoundException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
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

    @GetMapping(value = "/get/product")
    public ResponseEntity<ResponseModel> doGetListProduk(@RequestBody ProductModel productModel) {
        try {
            List<ProductEntity> product = transactionService.doGetListProduk(productModel);

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

    // @PostMapping(value = "/calculate/transcictetap")
    // public ResponseEntity<ResponseModel> doHitungTrxCicTetap(@RequestBody CicilanTetapEntity cicilanTetapEntity) throws ClientException, Exception {
    //     try {
    //         List<ProductEntity> product = transactionService.doHitungTrxCicTetap(cicilanTetapEntity);

    //         ResponseModel response = new ResponseModel();
    //         response.setMsg("Sukses Simpan transaksi");
    //         response.setData(product);
    //         return ResponseEntity.ok(response);
    //     } catch (ClientException e) {
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg(e.getMessage());

    //         return ResponseEntity.badRequest().body(response);
    //     } catch (Exception e) {
    //         ResponseModel response = new ResponseModel();
    //         response.setMsg("Terjadi kesalahan pada server");
    //         e.printStackTrace();

    //         return ResponseEntity.internalServerError().body(response);
    //     }
    // }

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> doSaveTrxCicTetap(@RequestBody CicilanTetapModel cicilanTetapModel) throws ClientException{
        try {
            CicilanTetapEntity trxCicTetap = transactionService.doSaveTrxCicTetap(cicilanTetapModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Transaksi Ciciclan Tetap ditemukan");
            response.setData(trxCicTetap);
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
}
