package by.ecp.tests;

import by.ecp.dto.JobVacancyDto;
import by.ecp.dto.SystemUserDto;
import by.ecp.entity.*;
import by.ecp.services.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class JobServiceTest extends BaseTest {

    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private VacancyService vacancyService;


    @Test
    public void save() {
        JobVacancyDto jobVacancyDto = new JobVacancyDto();
        jobVacancyDto.setNameUser("VVV");
        jobVacancyDto.setFamilyUser("xxx");
        jobVacancyDto.setEmail("vvv@vvv.by");
        jobVacancyDto.setGender(Gender.MALE);
        jobVacancyDto.setEnglish(English.EXELLENCE);
        jobVacancyDto.setComment("aaaaaasssssssssddddd");
        Company company = new Company();
        Vacancy vacancy = new Vacancy();
        Job job = new Job();
        job.setNameUser(jobVacancyDto.getNameUser());
        job.setFamilyUser(jobVacancyDto.getFamilyUser());
        job.setEnglish(jobVacancyDto.getEnglish());
        job.setGender(jobVacancyDto.getGender());
        company.setName("HHH");
        companyService.save(company);
        vacancy.setNameVacancy("fff");
        vacancy.setCompany(company);
        vacancyService.save(vacancy);
        job.setVacancy(vacancy);
        jobService.save(job);
        List<Job> jobList = jobService.findAll();
        assertThat(jobList, notNullValue());
    }
}

