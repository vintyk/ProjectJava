package by.ecp.tests;

import by.ecp.dto.JobVacancyDto;
import by.ecp.dto.VacancyDto;
import by.ecp.entity.*;
import by.ecp.services.CompanyService;
import by.ecp.services.JobService;
import by.ecp.services.VacancyService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;


public class VacancyServiceTest extends BaseTest {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private CompanyService companyService;


    @Test
    public void save() {
        VacancyDto vacancyDto = new VacancyDto();
        vacancyDto.setNameVacancy("fffff");
        vacancyDto.setCompanyId("1");

        Company company = new Company();
        company.setName("gggg");
        companyService.save(company);
        assertThat(company, notNullValue());

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy(vacancyDto.getNameVacancy());
        vacancy.setCompany(company);
        vacancyService.save(vacancy);
        List<Vacancy> vacancyList= vacancyService.findAll();
        assertThat(vacancyList, notNullValue());
    }
}

