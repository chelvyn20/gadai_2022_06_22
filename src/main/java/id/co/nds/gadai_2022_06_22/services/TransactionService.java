package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.models.CustomerModel;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.repos.CustomerRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.CustomerSpec;

@Service
public class TransactionService implements Serializable{
    @Autowired
    CustomerRepo customerRepo;
    

    public void doSearchTransCicTetap() {

    }

    public void doGetDetailCicTetap() {
        
    }

    public List<CustomerEntity> doSearchPelanggan(CustomerModel customerModel) {
        List<CustomerEntity> customers = new ArrayList<>();
        CustomerSpec specs = new CustomerSpec(customerModel);
        customerRepo.findAll(specs).forEach(customers::add);
        ArrayList response = new ArrayList<>();
        for (CustomerEntity customerEntity : customers) {
            response.add("custId: " + customers.get(0).getCustId());
            response.add("custKtp: " + customers.get(0).getCustKtp());
            response.add("custHp: " + customers.get(0).getCustHp());
            response.add("custName: " + customers.get(0).getCustName());
        }

        return response;
    }

    public List<ProductEntity> doGetListProduk(String productId) {
        return null;
    }

    public void doHitungTrxCicTetap() {

    }

    public void doSaveTrxCicTetap(CustomerModel customerModel) {
        List<CustomerEntity> customer = doSearchPelanggan(customerModel);
    }

}
