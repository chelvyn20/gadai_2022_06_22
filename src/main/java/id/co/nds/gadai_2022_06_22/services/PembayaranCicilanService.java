package id.co.nds.gadai_2022_06_22.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.DendaKeterlambatanEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanModel;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.models.PembayaranCicilanModel;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.DendaKeterlambatanRepo;
import id.co.nds.gadai_2022_06_22.validators.CicilanTetapValidator;

@Service
public class PembayaranCicilanService {
    @Autowired
    private CicilanTetapRepo cicilanTetapRepo;

    @Autowired
    private CicilanRepo cicilanRepo;

    @Autowired
    private DendaKeterlambatanRepo dendaKeterlambatanRepo;

    @Autowired
    private CicilanTetapService cicilanTetapService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    CicilanTetapValidator cicilanTetapValidator = new CicilanTetapValidator();

    public List<PembayaranCicilanModel> doSearchBayarCicTetap(CicilanTetapModel cicilanTetapModel) throws ClientException, NotFoundException {
        List<PembayaranCicilanModel> allModel = new ArrayList<>();
        List<CicilanEntity> cicilan = cicilanRepo.getPembayaranCicTetap(cicilanTetapModel.getNoTransaksi());
        CicilanTetapEntity tetap = cicilanTetapService.doGetDetailCicTetap(cicilanTetapModel);

        for(Integer i = 0; i < cicilan.size(); i++) {
            PembayaranCicilanModel model = new PembayaranCicilanModel();
            List<DendaKeterlambatanEntity> denda = dendaKeterlambatanRepo.findByNoTransaksiCicilanKe(cicilanTetapModel.getNoTransaksi(), cicilan.get(i).getCicilanKe());
            long jumlahDenda = dendaKeterlambatanRepo.getCountDendaKeterlambatan(cicilanTetapModel.getNoTransaksi(), cicilan.get(i).getCicilanKe());
            ProductEntity product = productService.doGetDetailProduct(tetap.getProductId());

            model.setNoTransaksi(tetap.getNoTransaksi());
            model.setTanggalTransaksi(tetap.getTglTx());
            model.setProductName(product.getProductName());

            if(cicilanTetapModel.getCustId() != null) {
                CustomerEntity customer = customerService.findById(cicilanTetapModel.getCustId());
                model.setCustId(customer.getCustId());
                model.setCustKtp(customer.getCustKtp());
                model.setCustName(customer.getCustName());
            }

            model.setCicilanKe(cicilan.get(i).getCicilanKe());
            model.setTotalTagihan((jumlahDenda * denda.get(0).getBiayaDenda()) + (cicilan.get(i).getTxPokok() + cicilan.get(i).getTxBunga()));
            model.setStatusCicilan(cicilan.get(i).getTxStatus());
            model.setTanggalAktifCicilan(tetap.getTglTx());
            model.setTanggalJatuhTempoCicilan(tetap.getTglJatuhTempo());
            allModel.add(model);
        }

        return allModel;
    }

    public CicilanTetapEntity doGetDetailTagihanCic(String noTransaksi) throws ClientException, NotFoundException{
        CicilanTetapEntity tetap = cicilanTetapRepo.findById(noTransaksi).orElse(null);
        // CustomerEntity customer = customerService.findById(tetap.getCustId());
        return tetap;
    }

    public List<CicilanTetapEntity> doUpdatePembayaran(CicilanTetapModel cicilanTetapModel) throws ClientException {
        List<CicilanTetapEntity> cicilan = cicilanTetapService.doSearchTransCicTetap(cicilanTetapModel);

        return cicilan;
    }
}
