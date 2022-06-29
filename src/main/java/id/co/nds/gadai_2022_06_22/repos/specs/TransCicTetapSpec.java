package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.models.CicilanTetapModel;

public class TransCicTetapSpec implements Specification<CicilanTetapEntity> {
    private CicilanTetapModel cicilanTetapModel;

    public TransCicTetapSpec(CicilanTetapModel cicilanTetapModel) {
        super();
        this.cicilanTetapModel = cicilanTetapModel;
    }

    @Override
    public Predicate toPredicate(Root<CicilanTetapEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate p = cb.and();

        if (cicilanTetapModel.getNoTransaksi() != null && cicilanTetapModel.getNoTransaksi().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("noTransaksi"), cicilanTetapModel.getNoTransaksi()));
        }

        if (cicilanTetapModel.getProductId() != null && cicilanTetapModel.getProductId().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("productId"), cicilanTetapModel.getProductId()));
        }

        if (cicilanTetapModel.getCustId() != null && cicilanTetapModel.getCustId().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("custId"), cicilanTetapModel.getCustId()));
        }

        cq.orderBy(cb.asc(root.get("noTransaksi")));
        return p;
    }
}
