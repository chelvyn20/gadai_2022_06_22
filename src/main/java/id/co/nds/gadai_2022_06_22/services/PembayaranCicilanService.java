package id.co.nds.gadai_2022_06_22.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.DendaKeterlambatanEntity;
import id.co.nds.gadai_2022_06_22.entities.PembayaranEntity;
import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.models.CustomerPaymentModel;
import id.co.nds.gadai_2022_06_22.models.PembayaranCicilanModel;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.DendaKeterlambatanRepo;
import id.co.nds.gadai_2022_06_22.repos.PembayaranRepo;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
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
    private ProductRepo productRepo;

    @Autowired
    private PembayaranRepo pembayaranRepo;

    @Autowired
    private CicilanTetapService cicilanTetapService;

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

    public PembayaranCicilanModel doGetDetailTagihanCic(String noTransaksi, Integer cicilanKe) throws ClientException, NotFoundException{
        CicilanTetapEntity tetap = cicilanTetapRepo.findById(noTransaksi).orElse(null);
        List<CicilanEntity> cicilan = cicilanRepo.getPembayaranCicTetap(tetap.getNoTransaksi());
        List<DendaKeterlambatanEntity> denda = dendaKeterlambatanRepo.findByNoTransaksiCicilanKe(tetap.getNoTransaksi(), cicilanKe);
        long jumlahDenda = dendaKeterlambatanRepo.getCountDendaKeterlambatan(tetap.getNoTransaksi(), cicilanKe);
        CustomerEntity customer = customerService.findById(tetap.getCustId());
        ProductEntity product = productRepo.getActiveProductByProductId(tetap.getProductId());

        PembayaranCicilanModel model = new PembayaranCicilanModel();
        model.setCustId(customer.getCustId());
        model.setCustName(customer.getCustName());
        model.setTanggalTransaksi(tetap.getTglTx());
        model.setNoTransaksi(tetap.getNoTransaksi());
        model.setTotalNilaiPinjaman(tetap.getTotalNilaiPinj());
        model.setTenor(product.getProductJangkaWaktu());
        model.setTanggalJatuhTempoCicilan(tetap.getTglJatuhTempo());
        model.setProductId(tetap.getProductId());
        model.setProductName(product.getProductName());
        model.setProductName(product.getProductDesc());
        model.setTotalKewajiban((cicilan.get(0).getTxPokok() + cicilan.get(0).getTxBunga()) * jumlahDenda);
        model.setTotalDenda(jumlahDenda * denda.get(0).getBiayaDenda());
        PembayaranEntity pembayaran = pembayaranRepo.getPembayaranDetailByNoTransaksi(noTransaksi);
        if(pembayaran != null) {
            model.setTotalPembayaran(pembayaran.getJumlahPembayaran());
        } else {
            model.setTotalPembayaran((double) 0);
        }
        model.setSisaKewajiban((((cicilan.get(0).getTxPokok() + cicilan.get(0).getTxBunga()) * jumlahDenda) 
        + (jumlahDenda * denda.get(0).getBiayaDenda())));

        return model;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public List<PembayaranEntity> doUpdatePembayaran(CustomerPaymentModel customerPaymentModel) throws ClientException, NotFoundException {
        CicilanTetapEntity tetap = cicilanTetapRepo.findById(customerPaymentModel.getNoTransaksi()).orElse(null);
        List<CicilanEntity> cicilan = cicilanRepo.getPembayaranCicTetap(customerPaymentModel.getNoTransaksi());
        ProductEntity product = productRepo.getActiveProductByProductId(tetap.getProductId());
        List<PembayaranEntity> daftarPembayaran = new ArrayList<>();

        for(Integer i = 0; i < customerPaymentModel.getSelectedCicilanKe().size(); i++) {
            PembayaranEntity pembayaran = new PembayaranEntity();
            pembayaran.setNoTransaksi(customerPaymentModel.getNoTransaksi());
            PembayaranCicilanModel detailPembayaran = doGetDetailTagihanCic(customerPaymentModel.getNoTransaksi(), customerPaymentModel.getSelectedCicilanKe().get(i));
            pembayaran.setTotalTagihanCicilan(cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).getTxPokok() + cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).getTxBunga());
            pembayaran.setTotalTagihanDenda(detailPembayaran.getTotalDenda());
            pembayaran.setBiayaAdmTutup(product.getBiayaAdmTutupVal());
            pembayaran.setTotalTagihan((cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).getTxPokok() + cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).getTxBunga()) + (detailPembayaran.getTotalDenda()) +
            (product.getBiayaAdmTutupVal()) - (cicilan.get(0).getTxBunga() + detailPembayaran.getTotalDenda()));
            pembayaran.setPembulatan(Math.floor((cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).getTxPokok() + cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).getTxBunga()) + (detailPembayaran.getTotalDenda()) +
            (product.getBiayaAdmTutupVal()) - (cicilan.get(0).getTxBunga() + detailPembayaran.getTotalDenda())));
            pembayaran.setJumlahPembayaran(customerPaymentModel.getJumlahPembayaran());
            pembayaran.setMetodeBayar(customerPaymentModel.getMetodeBayar());
            pembayaranRepo.save(pembayaran);
            daftarPembayaran.add(pembayaran);
    
            cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).setTxStatus("DIBAYAR");
            cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).setTanggalBayar(LocalDateTime.now());
            cicilan.get(customerPaymentModel.getSelectedCicilanKe().get(i)).setNoPembayaran(pembayaran.getNoPembayaran());

            List<DendaKeterlambatanEntity> denda = dendaKeterlambatanRepo.findByNoTransaksiCicilanKe(customerPaymentModel.getNoTransaksi(), customerPaymentModel.getSelectedCicilanKe().get(i));
            for(Integer j = 0; j < denda.size(); j++) {
                denda.get(j).setNoPembayaran(pembayaran.getNoPembayaran());
                denda.get(j).setTglPembayaranDenda(LocalDateTime.now());
            }
        }

        Integer count = 0;
        for(Integer i = 0; i < cicilan.size(); i++) {
            if(cicilan.get(i).getTxStatus() == "DIBAYAR") {
                count++;
            }
        }

        if(count == cicilan.size()) {
            tetap.setTxStatus("LUNAS");
        }
        
        return daftarPembayaran;
    }
}
