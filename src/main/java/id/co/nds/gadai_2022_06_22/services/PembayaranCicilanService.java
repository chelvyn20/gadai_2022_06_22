package id.co.nds.gadai_2022_06_22.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.entities.CustomerEntity;
import id.co.nds.gadai_2022_06_22.entities.DendaKeterlambatanEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.models.PembayaranCicilanModel;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;
import id.co.nds.gadai_2022_06_22.repos.CicilanTetapRepo;
import id.co.nds.gadai_2022_06_22.repos.DendaKeterlambatanRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.BayarCicTetapSpec;
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

    CicilanTetapValidator cicilanTetapValidator = new CicilanTetapValidator();

    public List<PembayaranCicilanModel> doSearchBayarCicTetap(CicilanTetapModel cicilanTetapModel) throws ClientException, NotFoundException {
        List<PembayaranCicilanModel> allModel = new ArrayList<>();
        CustomerEntity customer = customerService.findById(cicilanTetapModel.getCustId());
        List<CicilanEntity> cicilan = cicilanRepo.getPembayaranCicTetap(cicilanTetapModel.getNoTransaksi());
        CicilanTetapEntity tetap = cicilanTetapService.doGetDetailCicTetap(cicilanTetapModel);
// System.out.println(cicilan.size());
        for(Integer i = 0; i < cicilan.size(); i++) {
            PembayaranCicilanModel model = new PembayaranCicilanModel();
            List<DendaKeterlambatanEntity> denda = dendaKeterlambatanRepo.findByNoTransaksiCicilanKe(cicilanTetapModel.getNoTransaksi(), cicilan.get(i).getCicilanKe());
            Integer jumlahDenda = dendaKeterlambatanRepo.getCountDendaKeterlambatan(cicilanTetapModel.getNoTransaksi(), cicilan.get(i).getCicilanKe());
            model.setNoTransaksi(tetap.getNoTransaksi());
            model.setTanggalTransaksi(tetap.getTglTx());
            model.setCustId(customer.getCustId());
            model.setCustKtp(customer.getCustKtp());
            model.setCustName(customer.getCustName());
            model.setCicilanKe(cicilan.get(i).getCicilanKe());
            System.out.println(denda);
            if(denda.get(i).getBiayaDenda() != null) 
                model.setTotalTagihan(cicilan.get(i).getTxPokok() + denda.get(i).getBiayaDenda() * jumlahDenda); 
            model.setTotalTagihan(cicilan.get(i).getTxPokok());
            model.setStatusCicilan(cicilan.get(i).getTxStatus());
            model.setTanggalAktifCicilan(tetap.getTglTx());
            model.setTanggalJatuhTempoCicilan(tetap.getTglJatuhTempo());
            allModel.add(model);
        }

        return allModel;
            
        //     if(jumlahKeterlambatan > 0) {
        //         a.add("b");
        //         a.add("Total: " + cicilan.get(i).getTxPokok() + denda.get(0).getBiayaDenda() * jumlahKeterlambatan);
        //     }

        //     else {
        //         a.add("Total Tagihan: " + cicilan.get(i).getTxPokok());
        //     }
        //     // Double totalDenda = (denda.size() == 0 ? 0 : denda.get(0).getBiayaDenda() * denda.size());
        //     // a.add("Total Tagihan: " + cicilan.get(i).getTxPokok() + denda);
        //     // a.add("Total Tagihan: " + (cicilan.get(i).getTxPokok() + denda.get(i).getBiayaDenda().doubleValue()));
        //     a.add("Status Cicilan: " + cicilan.get(i).getTxStatus());
        //     a.add("Tanggal Aktif Cicilan: " + tetap.getTglTx());
        //     a.add("Tanggal Jatuh Tempo Cicilan: " + tetap.getTglJatuhTempo());
        // }
        // List<CicilanEntity> listCicilan = new ArrayList<>();

        // dendaKeterlambatanRepo.findAll().forEach(denda::add);
        // return denda;
        // System.out.println(denda.get(0).getBiayaDenda());
        
        // List<String> a = new ArrayList<>();
        // // a.add(denda);
        // for(Integer i = 0; i < cicilan.size(); i++) {
        //     // List<String> a = new ArrayList<>();
        //     // List<DendaKeterlambatanEntity> denda = dendaKeterlambatanRepo.getTotalPembayaranByNoTransaksiCicilan(cicilanTetapModel.getNoTransaksi(), i);
        //     Integer jumlahKeterlambatan = dendaKeterlambatanRepo.getCountDendaKeterlambatan(cicilanTetapModel.getNoTransaksi(), i);
        //     a.add("No Transaksi: " + tetap.getNoTransaksi());
        //     a.add("Tanggal Transaksi: " + tetap.getTglTx());
        //     a.add("Id Pelanggan: " + customer.getCustId());
        //     a.add("No KTP: " + customer.getCustKtp());
        //     a.add("Nama Pelanggan: " + customer.getCustName());
        //     a.add("Cicilan ke: " + cicilan.get(i).getCicilanKe());
            
        //     if(jumlahKeterlambatan > 0) {
        //         a.add("b");
        //         a.add("Total: " + cicilan.get(i).getTxPokok() + denda.get(0).getBiayaDenda() * jumlahKeterlambatan);
        //     }

        //     else {
        //         a.add("Total Tagihan: " + cicilan.get(i).getTxPokok());
        //     }
        //     // Double totalDenda = (denda.size() == 0 ? 0 : denda.get(0).getBiayaDenda() * denda.size());
        //     // a.add("Total Tagihan: " + cicilan.get(i).getTxPokok() + denda);
        //     // a.add("Total Tagihan: " + (cicilan.get(i).getTxPokok() + denda.get(i).getBiayaDenda().doubleValue()));
        //     a.add("Status Cicilan: " + cicilan.get(i).getTxStatus());
        //     a.add("Tanggal Aktif Cicilan: " + tetap.getTglTx());
        //     a.add("Tanggal Jatuh Tempo Cicilan: " + tetap.getTglJatuhTempo());
        //     // b.addAll(a);
        // }
   
        // // a.add();
        // // a.add(cicilan.toString());
        // // a.add(tetap.toString());

        // return a;

        // List<CicilanEntity> daftarPembayaran = cicilanRepo.getPembayaranCicTetap(cicilanTetapModel.getNoTransaksi());
        // daftarPembayaran.get(0).getCicilanKe();
        // List<CicilanTetapEntity> customer = transactionService.doSearchPelanggan(daftarPembayaran.get(0).get)
        // List<CicilanTetapEntity> bayarCicTetap = transactionService.doSearchTransCicTetap(cicilanTetapModel);
        // bayarCicTetap.get(0).getCustId();
        // bayarCicTetap.get(0).getcustname;
        // bayarCicTetap.get(0).getTglTx();
        // bayarCicTetap.get(0).getTglJatuhTempo();
        // bayarCicTetap.add(daftarPembayaran);
        // BayarCicTetapSpec bayarCicTetapSpec = new BayarCicTetapSpec(cicilanTetapModel);
        // cicilanTetapRepo.findAll(bayarCicTetapSpec).forEach(bayarCicTetap::add);
        // return daftarPembayaran;
    }

    public void doGetDetailTagihanCic() {

    }

    public void doUpdatePembayaran() {

    }
}
