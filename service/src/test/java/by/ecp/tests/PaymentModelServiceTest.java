package by.ecp.tests;

import by.ecp.entity.PaymentModel;
import by.ecp.services.PaymentModelService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class PaymentModelServiceTest extends BaseTest{
    @Autowired
    private PaymentModelService paymentModelService;

    @Test
    public void findAll(){
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("a");
        paymentModelService.save(paymentModel);
        List<PaymentModel> paymentModelList = paymentModelService.findAll();
        assertThat(paymentModel, notNullValue());
        PaymentModel paymentModel1 = paymentModelService.findOne(1L);
        assertThat(paymentModel1, notNullValue());
    }
}
