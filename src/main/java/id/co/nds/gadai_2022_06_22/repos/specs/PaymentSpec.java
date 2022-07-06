
package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.PaymentEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.PaymentModel;




public class PaymentSpec implements Specification<PaymentEntity> {
    private PaymentModel paymentModel;

    public PaymentSpec(PaymentModel paymentModel){
        super();
        this.paymentModel=paymentModel;
    }
  
    @Override
    public Predicate toPredicate(Root<PaymentEntity> root, CriteriaQuery<?>cq, CriteriaBuilder cb){
        Predicate p = cb.and();
        
        if (paymentModel.getNoTransaksi() != null && paymentModel.getNoTransaksi().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("noTransaksi"), paymentModel.getNoTransaksi()));
        }

        if (paymentModel.getCustId() != null && paymentModel.getCustId().length() > 0) {
            p.getExpressions().add(cb.equal(root.get("custId"), paymentModel.getCustId()));
        }


        cq.orderBy(cb.asc(root.get("noTransaksi")));
        return p;

    }
    
    
    
}
