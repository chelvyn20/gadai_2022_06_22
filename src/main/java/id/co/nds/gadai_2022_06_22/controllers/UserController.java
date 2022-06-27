package id.co.nds.gadai_2022_06_22.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai_2022_06_22.entities.UserEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.models.ResponseModel;
import id.co.nds.gadai_2022_06_22.models.UserModel;
import id.co.nds.gadai_2022_06_22.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;
    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel> doInsert(@RequestBody UserModel userModel) throws ClientException {
        try {
            UserEntity user = userService.doInsert(userModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Input Data User Baru.");
            response.setData(user);
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

    @PutMapping(value = "/update")
    public ResponseEntity<ResponseModel> doUpdate(@RequestBody UserModel userModel) throws ClientException, NotFoundException{
        try {
            UserEntity user = userService.doUpdate(userModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Update Data User Baru.");
            response.setData(user);
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

    @DeleteMapping(value = "/delete")
    public ResponseEntity<ResponseModel> doDelete(@RequestBody UserModel userModel) throws ClientException, NotFoundException{
        try {
            UserEntity user = userService.doDelete(userModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Sukses Menghapus Data User");
            response.setData(user);
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

    @GetMapping(value = "/get/all")
    public ResponseEntity<ResponseModel> doSearchUser(UserModel userModel) {
        try {
            List<UserEntity> user = userService.doSearchUser(userModel);

            ResponseModel response = new ResponseModel();
            response.setMsg("Data user:");
            response.setData(user);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseModel> doGetDetailUser(@RequestParam Integer id) throws ClientException, NotFoundException{
        try {
            UserEntity user = userService.doGetDetailUser(id);

            ResponseModel response = new ResponseModel();
            response.setMsg("User ditemukan");
            response.setData(user);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ResponseModel response = new ResponseModel();
            response.setMsg("Terjadi kesalahan pada server");
            e.printStackTrace();

            return ResponseEntity.internalServerError().body(response);
        }
    }
}
