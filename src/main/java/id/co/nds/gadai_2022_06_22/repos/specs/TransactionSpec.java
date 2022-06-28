package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;

public class TransactionSpec implements Specification<CicilanTetapEntity> {
    private CicilanTetapModel cicilanTetapModel;

    public TransactionSpec(CicilanTetapModel cicilanTetapModel){
        super();
        this.cicilanTetapModel=cicilanTetapModel;
    }

    @Override
    public Predicate toPredicate(Root<CicilanTetapEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();

        query.orderBy(criteriaBuilder.asc(root.get("no_transaksi")));
        return p;    
    }
    
}
