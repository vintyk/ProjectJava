package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.PaymentModelDaoImpl;
import by.ecp.entity.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SystemUser on 16.06.2017.
 */
public class PaymentModelDaoTest extends BaseDaoTest<PaymentModel> {
    @Autowired
    private BaseDao<PaymentModel> dao = new PaymentModelDaoImpl();

    @Override
    protected BaseDao<PaymentModel> getDao() {
        return dao;
    }

    @Override
    protected PaymentModel getModel() {
        return new PaymentModel();
    }

}
