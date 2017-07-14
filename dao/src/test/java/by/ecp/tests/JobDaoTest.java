package by.ecp.tests;

import by.ecp.db.CompanyDao;
import by.ecp.db.JobDao;
import by.ecp.db.VacancyDao;
import by.ecp.entity.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by SystemUser on 28.06.2017.
 */
public class JobDaoTest extends BaseTest {

    @Autowired
    private JobDao jobDao;
    @Autowired
    private VacancyDao vacancyDao;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testSave(){
        Company company = new Company();
        company.setName("MyNewCompany");
        companyDao.save(company);

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy("vacancy");
        vacancy.setCompany(company);
        vacancyDao.save(vacancy);

        Job job = new Job();
        job.setNameUser("Jon");
        job.setFamilyUser("Dorian");
        job.setEmail("vvv@ecp.by");
        job.setGender(Gender.MALE);
        job.setEnglish(English.EXELLENCE);
        job.setComment("Я очень круттттт!!!!!");
        job.setVacancy(vacancy);
        jobDao.save(job);
        Job result = jobDao.findOne(1L);
        assertNotNull(result);
        List<Job> jobList = jobDao.findAll();
        System.out.println(result);
        assertNotNull(jobList);
    }

}
