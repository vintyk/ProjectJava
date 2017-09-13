package by.ecp.tests;


import by.ecp.db.CompanyDao;
import by.ecp.db.VacancyDao;
import by.ecp.entity.Company;
import by.ecp.entity.Vacancy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

/**
 * Created by Vinty on 18.06.2017.
 */
public class VacancyDaoTest extends BaseTest{
    @Autowired
    private VacancyDao vacancyDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFindByName(){
        Company company2 = new Company();
        company2.setName("MyCompany");
        companyDao.save(company2);
        vacancyDao.saveVacancy("vac", 1L);
        Vacancy result = vacancyDao.findOne(1L);
        System.out.println(result);
        assertEquals(result.getNameVacancy(), "vac");
        Vacancy result2 = vacancyDao.findByName("vac");
        assertEquals(result.getNameVacancy(), "vac");
    }

}
