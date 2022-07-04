
package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;


import id.co.nds.gadai_2022_06_22.entities.CicilanTetapEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.TrxModel;




public class TrxSpec implements Specification<CicilanTetapEntity> {
    private TrxModel trxModel;

    public TrxSpec(TrxModel trxModel){
        super();
        this.trxModel=trxModel;
    }
  
    @Override
    public Predicate toPredicate(Root<CicilanTetapEntity> root, CriteriaQuery<?>cq, CriteriaBuilder cb){
        Predicate p = cb.and();
        
        if (trxModel.getNoTransaksi() != null && trxModel.getNoTransaksi().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("noTransaksi"), trxModel.getNoTransaksi()));
        }

        if (trxModel.getProductId() != null && trxModel.getProductId().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("productId"), trxModel.getProductId()));
        }

        if (trxModel.getCustId() != null && trxModel.getCustId().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("custId"), trxModel.getCustId()));
        }

       
//         if (trxModel.getStatusTrans() != null
//         && (trxModel.getStatusTrans().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_ACTIVE)
//                 || trxModel.getStatusTrans().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE))) {
//         p.getExpressions()
//             .add(cb.equal(cb.upper(root.get("statusTrans")), trxModel.getStatusTrans().toUpperCase()));
// }
        cq.orderBy(cb.asc(root.get("noTransaksi")));
        return p;

    }
    
    
    
}
