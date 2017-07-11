package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SystemUser on 09.06.2017.
 */
@Repository
public class PaymentModelDaoImpl extends BaseDaoImpl<PaymentModel> implements PaymentModelDao{

//    @Override
//    public List<PaymentModel> ListAll() {
//        Session session = getSessionFactory().getCurrentSession();
//        QPaymentModel paymentModel = new QPaymentModel("myPayment");
//        JPAQuery<PaymentModel> query = new JPAQuery<>(session);
//        query.select(paymentModel).from(paymentModel);
//        return query.fetchResults().getResults();
//    }
}
