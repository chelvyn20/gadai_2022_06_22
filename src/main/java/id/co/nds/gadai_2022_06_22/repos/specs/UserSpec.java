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

        if(userModel.getId() != null && userModel.getId() != 0) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("id"), userModel.getId()));
        }

        if(userModel.getUserId() != null && userModel.getUserId().length() > 0 ) {
            p.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("userId")), "%" 
            + userModel.getUserId().toLowerCase() + "%"));
        }

        if(userModel.getUserName() != null && userModel.getUserName().length() > 0) {
            p.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("userName")), "%" 
            + userModel.getUserName().toLowerCase() + "%"));
        }

        if(userModel.getUserDesc() != null && userModel.getUserDesc().length() > 0) {
            p.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("userDesc")), "%" 
            + userModel.getUserDesc().toLowerCase() + "%"));
        }

        if(userModel.getUserNoHp() != null && userModel.getUserNoHp().length() > 0) {
            p.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("userNoHp")), "%" 
            + userModel.getUserNoHp().toLowerCase() + "%"));
        }
        
        if(userModel.getActorId() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("actorId"), userModel.getActorId()));
        }

        if(userModel.getRecStatus() != null && 
        (userModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_ACTIVE) 
        || userModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE))) {
            p.getExpressions().add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("recStatus")), 
            userModel.getRecStatus().toUpperCase()));
        }

        query.orderBy(criteriaBuilder.asc(root.get("id")));

        return p;
    }
    
}
