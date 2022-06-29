package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.UserEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.UserModel;
import id.co.nds.gadai_2022_06_22.repos.UserRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.UserSpec;
import id.co.nds.gadai_2022_06_22.validators.UserValidator;

@Service
public class UserService implements Serializable{
    @Autowired
    private UserRepo userRepo;

    UserValidator userValidator = new UserValidator();

    public UserEntity doInsert(UserModel userModel) throws ClientException, Exception{
        userValidator.notNullCheckUserId(userModel.getUserId());
        userValidator.nullCheckUserId(userModel.getUserId());
        userValidator.validateUserId(userModel.getUserId());

        Long countUserId = userRepo.countByUserId(userModel.getUserId());

        if(countUserId > 0) {
            throw new ClientException("User id telah terdaftar");
        }

        userValidator.nullCheckUserName(userModel.getUserName());
        userValidator.validateUserName(userModel.getUserName());
        userValidator.nullCheckUserPhoneNumber(userModel.getUserNoHp());
        userValidator.validatePhoneNumber(userModel.getUserNoHp());

        Long countPhoneNumber = userRepo.countByPhoneNumber(userModel.getUserNoHp());

        if(countPhoneNumber > 0) {
            throw new ClientException("Nomor Hp telah terdaftar");
        }

        userValidator.nullCheckUserMaxTransaction(userModel.getUserTxnLimit());
        userValidator.validateUserTransactionLimit(userModel.getUserTxnLimit());
        userValidator.nullCheckUserEntryDate(userModel.getEntryDate());    
        userValidator.validateEntryDate(userModel.getEntryDate());  

        UserEntity user = new UserEntity();
        user.setUserId(userModel.getUserId());
        user.setUserName(userModel.getUserName());
        user.setUserNoHp(userModel.getUserNoHp());
        user.setUserDesc(userModel.getUserDesc());
        user.setUserTxnLimit(userModel.getUserTxnLimit());
        user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        user.setCreatedBy(userModel.getCreatedBy() == null ? 0 : userModel.getCreatedBy());
        DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate entryDate = LocalDate.parse(userModel.getEntryDate(), formatedDate);
        user.setEntryDate(entryDate);
        // user.setCreatedInputDetail(userModel.getUserId() + "-" + userModel.getUserName() + "/" + new Timestamp(System.currentTimeMillis()));
        user.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        
        return userRepo.save(user);
    }

    public UserEntity doUpdate(UserModel userModel) throws ClientException, NotFoundException {
        userValidator.nullCheckUserId(userModel.getUserId());

        if(userRepo.getActiveUserByUserId(userModel.getUserId()) == null) {
            throw new NotFoundException("Tidak dapat menemukan user dengan id: " + userModel.getUserId());
        }

        UserEntity user = new UserEntity();
        user = doGetDetailUser(userModel.getUserId());

        if(userModel.getUserName() != null) {
            userValidator.validateUserName(userModel.getUserName());
            user.setUserName(userModel.getUserName());
        }

        if(userModel.getUserNoHp() != null) {
            userValidator.validatePhoneNumber(userModel.getUserNoHp());
            Long countPhoneNumber = userRepo.countByPhoneNumber(userModel.getUserNoHp());

            if(countPhoneNumber > 0) {
                throw new ClientException("Nomor Hp telah terdaftar");
            }

            user.setUserNoHp(userModel.getUserNoHp());
        }

        if(userModel.getUserDesc() != null) {
            userValidator.validateUserDesc(userModel.getUserDesc());
            user.setUserDesc(userModel.getUserDesc());
        }

        if(userModel.getUserTxnLimit() != null) {
            userValidator.validateUserTransactionLimit(userModel.getUserTxnLimit());
            user.setUserTxnLimit(userModel.getUserTxnLimit());
        }

        if(userModel.getEntryDate() != null) {
            DateTimeFormatter formatedDate = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate entryDate = LocalDate.parse(userModel.getEntryDate(), formatedDate);
            userValidator.validateEntryDate(userModel.getEntryDate());
            user.setEntryDate(entryDate);
        }      

        user.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        user.setUpdatedBy(userModel.getUpdatedBy() == null ? 0 : userModel.getUpdatedBy());
        // user.setUpdatedInputDetail(user.getUserId() + "-" + userModel.getUserName() + "/" + new Timestamp(System.currentTimeMillis()));

        return userRepo.save(user);
    }

    public UserEntity doDelete(UserModel userModel) throws ClientException, NotFoundException {
        userValidator.nullCheckUserId(userModel.getUserId());
        userValidator.validateUserId(userModel.getUserId());

        if(userRepo.getActiveUserByUserId(userModel.getUserId()) == null) {
            throw new NotFoundException("Cannot find user with id: " + userModel.getUserId());
        }

        UserEntity user = new UserEntity();
        user = doGetDetailUser(userModel.getUserId());

        if(user.getRecStatus().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE)) {
            throw new ClientException("User id (" + userModel.getUserId() + ") is already been deleted.");
        }

        user.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        user.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        user.setDeletedBy(userModel.getDeletedBy() == null ? 0 : userModel.getDeletedBy());

        return userRepo.save(user);
    }

    public List<UserEntity> doSearchUser(UserModel userModel) {
        List<UserEntity> users = new ArrayList<>();
        UserSpec specs = new UserSpec(userModel);
        userRepo.findAll(specs).forEach(users::add);

        return users;
    }

    public UserEntity doGetDetailUser(String userId) throws ClientException, NotFoundException {
        userValidator.nullCheckUserId(userId);
        userValidator.validateUserId(userId);


        UserEntity user = userRepo.getActiveUserByUserId(userId);
        userValidator.nullCheckObject(user);

        return user;
    }
}
