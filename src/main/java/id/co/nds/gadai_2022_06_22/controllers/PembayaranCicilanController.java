package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.PembayaranEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;
import id.co.nds.gadai_2022_06_22.models.CustomerPaymentModel;
import id.co.nds.gadai_2022_06_22.models.PembayaranCicilanModel;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.services.PembayaranCicilanService;

@RestController
@RequestMapping(value = "/payment")
public class PembayaranCicilanController {
    @Autowired
    private PembayaranCicilanService pembayaranCicilanService;

    @GetMapping(value = "/search")
    public ResponseEntity<ResponseModel> doSearchBayarCicTetap(@RequestBody CicilanTetapModel cicilanTetapModel) throws ClientException {
        try {
            List<PembayaranCicilanModel> bayarCicTetap = pembayaranCicilanService.doSearchBayarCicTetap(cicilanTetapModel);
            ResponseModel response = new ResponseModel();
            response.setMsg("Detail Pembayaran Cicilan Tetap:");
            response.setData(bayarCicTetap);
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
    
    @GetMapping(value = "/get/detail")
    public ResponseEntity<ResponseModel> doGetDetailTagihanCic(@RequestParam String noTransaksi, @RequestParam Integer cicilanKe) throws ClientException {
        try {
            PembayaranCicilanModel bayarCicTetap = pembayaranCicilanService.doGetDetailTagihanCic(noTransaksi, cicilanKe);
            ResponseModel response = new ResponseModel();
            response.setMsg("Detail Tagihan Cicilan Tetap:");
            response.setData(bayarCicTetap);
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

    @PostMapping(value = "/pembayaran")
    public ResponseEntity<ResponseModel> doUpdatePembayaran(@RequestBody CustomerPaymentModel customerPaymentModel) throws ClientException {
        try {
            List<PembayaranEntity> bayarCicTetap = pembayaranCicilanService.doUpdatePembayaran(customerPaymentModel);
            ResponseModel response = new ResponseModel();
            response.setMsg("Detail Tagihan Cicilan Tetap:");
            response.setData(bayarCicTetap);
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
