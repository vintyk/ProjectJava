package by.ecp.tests;

import by.ecp.entity.PaymentModel;
import by.ecp.entity.Privilege;
import by.ecp.services.PaymentModelService;
import by.ecp.services.PrivilegeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static by.ecp.entity.QPaymentModel.paymentModel;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class PrivilegeServiceTest extends BaseTest{
    @Autowired
    private PrivilegeService privilegeService;

    @Test
    public void findAll(){
        Privilege privilege = new Privilege();
        privilege.setNamePrivilege("a");
        privilegeService.save(privilege);
        List<Privilege> privilegeList= privilegeService.findAll();
        assertThat(privilegeList, notNullValue());
        Privilege privilege22 = privilegeService.findOne(1L);
        assertThat(privilege22, notNullValue());
    }

}
