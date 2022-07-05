package id.co.nds.gadai_2022_06_22.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.TransCicTetapSpec;
import id.co.nds.gadai_2022_06_22.validators.CicilanTetapValidator;

@Service
public class CicilanTetapService {
    @Autowired
    private CicilanTetapRepo cicilanTetapRepo;

    CicilanTetapValidator cicilanTetapValidator = new CicilanTetapValidator();

    public List<CicilanTetapEntity> doSearchTransCicTetap(CicilanTetapModel cicilanTetapModel) {
        List<CicilanTetapEntity> transCicTetap = new ArrayList<>();
        TransCicTetapSpec transCicTetapSpec = new TransCicTetapSpec(cicilanTetapModel);
        cicilanTetapRepo.findAll(transCicTetapSpec).forEach(transCicTetap::add);
        return transCicTetap;
    }

    public CicilanTetapEntity doGetDetailCicTetap(CicilanTetapModel cicilanTetapModel) throws ClientException, NotFoundException {
        cicilanTetapValidator.nullCheckTransaksiNo(cicilanTetapModel.getNoTransaksi());
        cicilanTetapValidator.validateTransaksiNo(cicilanTetapModel.getNoTransaksi());

        CicilanTetapEntity transaksi = cicilanTetapRepo.getCicilanTetapTransactionByNoTransaksi(cicilanTetapModel.getNoTransaksi());
        cicilanTetapValidator.nullCheckObject(transaksi);

        return transaksi;
    }

}
