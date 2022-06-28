package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.TransactionEntity;
import id.co.nds.gadai_2022_06_22.models.TransactionModel;

public class TransactionSpec implements Specification<TransactionEntity> {
    private TransactionModel transactionModel;

    public TransactionSpec(TransactionModel transactionModel){
        super();
        this.transactionModel=transactionModel;
    }

    @Override
    public Predicate toPredicate(Root<TransactionEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();

        query.orderBy(criteriaBuilder.asc(root.get("id")));
        return p;    
    }
    
}
