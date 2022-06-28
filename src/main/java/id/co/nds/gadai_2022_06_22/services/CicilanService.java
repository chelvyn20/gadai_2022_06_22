package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.CicilanModel;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.CicilanSpec;
import id.co.nds.gadai_2022_06_22.repos.specs.CustomerSpec;
import id.co.nds.gadai_2022_06_22.validators.CicilanValidator;

@Service
public class CicilanService implements Serializable {
    @Autowired
    private CicilanRepo cicilanRepo;

    CicilanValidator cicilanValidator = new CicilanValidator(); 

    public CicilanEntity add(CicilanModel cicilanModel) throws ClientException{
       
        CicilanEntity transaksi =new CicilanEntity();
       

        return cicilanRepo.save(transaksi);
    } 
    
    public List<CicilanEntity> findAll(){
        List<CicilanEntity> transaksi = new ArrayList<>();
        cicilanRepo.findAll().forEach(transaksi::add);
        return transaksi;
    }
    
    // public List<CicilanEntity> findAllByCriteria(CicilanModel cicilanModel){
    //     List<CicilanEntity> cicilans = new ArrayList<>();
    //     CicilanSpec cicilanSpec = new CicilanSpec(cicilanModel);
    //     cicilanRepo.findAll(cicilanSpec).forEach(cicilans::add);
    //     return cicilans;
    // }
    
    public CicilanEntity findById(String id) throws ClientException, NotFoundException{
        

        CicilanEntity cicilan = cicilanRepo.findById(id).orElse( null);
        return cicilan;
    }

    // public List<CicilanEntity> findCustomerByCriteria(CicilanModel cicilanModel){
    //     List<CicilanEntity> costomer = new ArrayList<>();
    //     CustomerSpec cicilanSpec = new CustomerSpec(costomer);
    //     cicilanRepo.findAll(cicilanSpec).forEach(costomer::add);
    //     return costomer;
    // }

    public List<CicilanEntity> findAllProduct(){
        List<CicilanEntity> products = new ArrayList<>();
        cicilanRepo.findAll().forEach(products::add);
        return products;
    }
    
    

}
