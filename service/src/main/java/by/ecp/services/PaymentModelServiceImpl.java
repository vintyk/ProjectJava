package by.ecp.services;

import by.ecp.db.PaymentModelDao;
import by.ecp.entity.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
@Transactional
@Service
public class PaymentModelServiceImpl implements PaymentModelService {

    private final PaymentModelDao paymentModelDao;

    @Autowired
    public PaymentModelServiceImpl(PaymentModelDao paymentModelDao) {
        this.paymentModelDao = paymentModelDao;
    }

    @Override
    public List<PaymentModel> findAll() {
        return paymentModelDao.findAll();
    }

    @Override
    public PaymentModel findOne(Long id) {
        return paymentModelDao.findOne(id);
    }

    @Override
    public void save(PaymentModel paymentModel) {
        paymentModelDao.save(paymentModel);
    }
}
