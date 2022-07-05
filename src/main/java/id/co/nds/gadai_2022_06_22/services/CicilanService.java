package id.co.nds.gadai_2022_06_22.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.CicilanEntity;
import id.co.nds.gadai_2022_06_22.repos.CicilanRepo;

@Service
public class CicilanService {
    @Autowired
    private CicilanRepo cicilanRepo;

    public List<CicilanEntity> checkTransactionStatus() {
        List<CicilanEntity> listCicilan = new ArrayList<>();
        cicilanRepo.findAll().forEach(listCicilan::add);

        for(Integer i = 0; i < listCicilan.size(); i++) {
            if (LocalDateTime.now().isBefore(listCicilan.get(i).getTanggalAktif())) {
                listCicilan.get(i).setTxStatus("BELUM AKTIF");
            } 

            if (LocalDateTime.now().isAfter(listCicilan.get(i).getTanggalAktif()) && LocalDateTime.now().isBefore(listCicilan.get(i).getTanggalJatuhTempo()) ) {
                listCicilan.get(i).setTxStatus("AKTIF");
            } 

            if (LocalDateTime.now().isAfter(listCicilan.get(i).getTanggalAktif()) && LocalDateTime.now().isAfter(listCicilan.get(i).getTanggalJatuhTempo()) ) {
                listCicilan.get(i).setTxStatus("TERLAMBAT");
            } 

            // if ( listCicilan.get(i).getTanggalBayar() != null ) {
            //     listCicilan.get(i).setTxStatus("DIBAYAR");
            // }

            cicilanRepo.save(listCicilan.get(i));
        }

        return listCicilan;
    }
}
