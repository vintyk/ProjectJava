package by.ecp.controller;

import by.ecp.dto.VacancyDto;
import by.ecp.entity.Company;
import by.ecp.entity.Job;
import by.ecp.entity.Vacancy;
import by.ecp.services.CompanyService;
import by.ecp.services.JobService;
import by.ecp.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by User on 29.06.2017.
 */
@Controller
public class AdminToolController {

    private final VacancyService vacancyService;
    private final CompanyService companyService;
    private final JobService jobService;
    @Autowired
    public AdminToolController(VacancyService vacancyService,
                               CompanyService companyService,
                               JobService jobService){
        this.vacancyService = vacancyService;
        this.companyService = companyService;
        this.jobService = jobService;
    }

    @ModelAttribute("jobs")
    public List<Job> jobs(){
        return jobService.findAll();
    }
    @ModelAttribute("vacancyDto")
    public VacancyDto vacancyDto() {
        return new VacancyDto();
    }
    @ModelAttribute("companies")
    public List<Company> companies() {
        return companyService.findAll();
    }

    @GetMapping("/adminTool")
    public String showLoginPage() {
        return "AdminTool";
    }


    @PostMapping(path = "/adminTool")
    public String tempVacancyDto(VacancyDto vacancyDto, Model model){
        Company company = companyService.findById(Long.valueOf(vacancyDto.getCompanyId()));
        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy(vacancyDto.getNameVacancy());
        vacancy.setCompany(company);
        vacancyService.save(vacancy);
        return "AdminTool";
    }
}

