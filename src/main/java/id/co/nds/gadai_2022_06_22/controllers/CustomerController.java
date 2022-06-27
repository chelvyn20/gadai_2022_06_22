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

import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.CustomerService;

@RestController
@RequestMapping("/pelanggan")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> doInsertPelanggan(@RequestBody CustomerModel customerModel) {
        try {
            // request
            CustomerEntity customer = customerService.add(customerModel);

            // response
            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Input Data Pelanggan Baru");
            response.setData(customer);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get")
    public ResponseEntity<ResponseModel> doDisplayAllPelanggan() {
        try {
            // request
            List<CustomerEntity> customers = customerService.findAll();

            // response
            ResponseModel response = new ResponseModel();
            response.setMsg("Hasil Pencarian");
            response.setData(customers);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get/search")
    public ResponseEntity<ResponseModel> doSearchPelanggan(@RequestBody CustomerModel customerModel) {
        try {
            // request
            List<CustomerEntity> customer = customerService.findAllByCriteria(customerModel);

            // response
            ResponseModel response = new ResponseModel();
            response.setMsg("Hasil Pencarian");
            response.setData(customer);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseModel> doDetailPelanggan(@PathVariable String id) {
        try {
            // request
            CustomerEntity customer = customerService.findById(id);

            // response
            ResponseModel response = new ResponseModel();
            response.setMsg("Hasil Pencarian");
            response.setData(customer);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ResponseModel> doUpdatePelanggan(@RequestBody CustomerModel customerModel) {
        try {
            // request
            CustomerEntity customer = customerService.edit(customerModel);

            // response
            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Ubah data pelanggan");
            response.setData(customer);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseModel> doDeletePelanggan(@RequestBody CustomerModel customerModel) {
        try {
            // request
            CustomerEntity customer = customerService.delete(customerModel);

            // response
            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses hapus data pelanggan");
            response.setData(customer);
            return ResponseEntity.ok(response);

        } catch (ClientException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch (NotFoundException e) {
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi Kesahalan Pada Server");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
