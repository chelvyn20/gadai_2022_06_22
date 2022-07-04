package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.UserEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.UserModel;

public class UserSpec implements Specification<UserEntity>{
    private UserModel userModel;

    public UserSpec(UserModel userModel) {
        super();
        this.userModel = userModel;
    }

    @Override
    public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();

        if(userModel.getUserId() != null && userModel.getUserId().length() > 0 ) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("userId"), userModel.getUserId().toLowerCase()));
        }

        if(userModel.getUserName() != null && userModel.getUserName().length() > 0) {
            p.getExpressions().add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("userName")), userModel.getUserName()));
        }

        if(userModel.getUserNotes() != null && userModel.getUserNotes().length() > 0) {
            p.getExpressions().add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("userNotes")), userModel.getUserNotes()));
        }

        if(userModel.getUserPhone() != null && userModel.getUserPhone().length() > 0) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("userPhone"), userModel.getUserPhone().toLowerCase()));
        }
        
        if(userModel.getCreatedBy() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("createdBy"), userModel.getCreatedBy()));
        }

        if(userModel.getRecStatus() != null && 
        (userModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_ACTIVE) 
        && userModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE))) {
            p.getExpressions().add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("recStatus")), 
            userModel.getRecStatus().toUpperCase()));
        }

        query.orderBy(criteriaBuilder.asc(root.get("userId")));

        return p;
    }
    
}
