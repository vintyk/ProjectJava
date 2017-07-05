package by.ecp.controller;

import by.ecp.dto.JobVacancyDto;
import by.ecp.entity.*;
import by.ecp.services.JobService;
import by.ecp.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Controller
public class GameProjectController {

    private final JobService jobService;
    private final VacancyService vacancyService;

    @Autowired
    public GameProjectController(JobService jobService, VacancyService vacancyService) {
        this.jobService = jobService;
        this.vacancyService = vacancyService;
    }

    @ModelAttribute("jobVacancyDto")
    public JobVacancyDto jobVacancyDto() {
        return new JobVacancyDto();
    }

    @ModelAttribute("vacancies")
    public List<Vacancy> vacancies() {
        return vacancyService.findAll();
    }
    @ModelAttribute("genders")
    public List<Gender> genders() {
        return Arrays.asList(Gender.values());
    }
    @ModelAttribute("englishes")
    public List<English> englishes() {
        return Arrays.asList(English.values());
    }

    @GetMapping(path = "/GameProject")
    public String showGameProjectForm() {
        return "GameProject";
    }

    @PostMapping(path = "/GameProject")
    public String tempJobVacancyDto(JobVacancyDto jobVacancyDto, Model model) {
        Vacancy vacancy = vacancyService.findOne(jobVacancyDto.getVacancyId());
        System.out.println("---------------------------------------------"+jobVacancyDto);
        Job job = new Job();
        job.setVacancy(vacancy);
        job.setNameUser(jobVacancyDto.getNameUser());
        job.setFamilyUser(jobVacancyDto.getFamilyUser());
        job.setEmail(jobVacancyDto.getEmail());
        job.setGender(jobVacancyDto.getGender());
        job.setEnglish(jobVacancyDto.getEnglish());
        job.setComment(jobVacancyDto.getComment());
        jobService.save(job);
        return "GameProject";
    }

//    @GetMapping(path = "/GameProject/{vacancyId}")
//    public String showGameProjectForm(@PathVariable("vacancyId") Long vacancyId, Model model) {
//        Vacancy vacancy = vacancyService.findOne(vacancyId);
//        model.addAttribute("vacancy", vacancy);
//        return "GameProject";
//    }

//    @PostMapping(path = "/GameProject")
//    public String saveJob(Job job, Model model) {
//        Long id = jobService.save(job);
//        model.addAttribute("vacancyId", id);
//        return "redirect:/GameProject/{vacancyId}";
//    }
}
