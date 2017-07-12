package by.ecp.tests;

import by.ecp.entity.Company;
import by.ecp.services.CompanyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class CompanyServiceTest extends BaseTest{
    @Autowired
    private CompanyService companyService;

    @Test
    public void findAll(){
        Company company = new Company();
        company.setName("a");
        List<Company> companyList = companyService.findAll();
        assertThat(companyList, notNullValue());
    }
    @Test
    public void findById(){
        Company company = new Company();
        company.setName("a");
        companyService.save(company);
        Company company1 = companyService.findById(1L);
        assertThat(company1, notNullValue());
    }

}
