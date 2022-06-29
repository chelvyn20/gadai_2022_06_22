package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.AuctionEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.models.AuctionModel;
import id.co.nds.gadai_2022_06_22.repos.AuctionRepo;
import id.co.nds.gadai_2022_06_22.validators.BarangValidator;

@Service
public class AuctionService implements Serializable{
    @Autowired
    AuctionRepo auctionRepo;

    BarangValidator auctionValidator = new BarangValidator();

    public AuctionEntity doInsertAuctionItem(AuctionModel auctionModel) throws ClientException {
        auctionValidator.notNullCheckId(auctionModel.getId());
        auctionValidator.nullCheckProductName(auctionModel.getProductName());
        auctionValidator.validateProductName(auctionModel.getProductName());
        auctionValidator.nullCheckProductCondition(auctionModel.getProductCondition());
        auctionValidator.nullCheckProductDesc(auctionModel.getProductDesc());
        auctionValidator.validateProductDesc(auctionModel.getProductDesc());
        auctionValidator.nullCheckProductQuantity(auctionModel.getProductQuantity());
        auctionValidator.validateProductQuantity(auctionModel.getProductQuantity());
        auctionValidator.nullCheckProductPrice(auctionModel.getProductPrice());
        auctionValidator.validateProductPrice(auctionModel.getProductPrice());

        AuctionEntity auction = new AuctionEntity();
        auction.setProductName(auctionModel.getProductName());
        auction.setProductCondition(auctionModel.getProductCondition());
        auction.setProductDesc(auctionModel.getProductDesc());
        auction.setProductQuantity(auctionModel.getProductQuantity());
        auction.setProductPrice(auctionModel.getProductPrice());
        
        return auctionRepo.save(auction);
    }
}
