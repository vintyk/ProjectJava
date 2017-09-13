package by.ecp.services;

import by.ecp.entity.PaymentModel;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
public interface PaymentModelService  {

    List<PaymentModel> findAll();

    PaymentModel findOne(Long id);

    void save(PaymentModel paymentModel);
}
