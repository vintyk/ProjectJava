package by.ecp.tests;

import by.ecp.entity.Company;
import by.ecp.entity.Country;
import by.ecp.services.CompanyService;
import by.ecp.services.CountryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class CountryServiceTest extends BaseTest{
    @Autowired
    private CountryService countryService;

    @Test
    public void findAll(){
        Country country = new Country();
        country.setName("a");
        List<Country> countryList = countryService.findAll();
        assertThat(countryList, notNullValue());
    }
    @Test
    public void findById(){
        Country country = new Country();
        country.setName("a");
        countryService.save(country);
        Country country1 = countryService.findOne(1L);
        assertThat(country1, notNullValue());
    }
    @Test
    public void saveWithReturnId(){
        Country country = new Country();
        country.setName("a");
        countryService.save(country);
        assertThat(country.getId(), notNullValue());
    }
}
