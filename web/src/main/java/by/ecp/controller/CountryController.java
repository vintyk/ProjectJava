package by.ecp.controller;

import by.ecp.entity.Country;
import by.ecp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by Vinty on 25.06.2017.
 */
@Controller
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @ModelAttribute("country")
    public Country country() {
        return new Country();
    }

    @ModelAttribute("countries")
    public List<Country> countries()
    {
        return countryService.findAll();
    }

    @GetMapping(path = "/country")
    public  String showCountryForm()
    {
        return "VerError";
    }

    @PostMapping(path = "/country")
    public String saveCountry(Country country){
        countryService.save(country);
        return "VerError";
    }

//    @GetMapping(path = "/country/{countryId}")
//    public String showCountryInfo(@PathVariable("countryId") Long countryId, Model model){
//        Country country = countryService.findOne(countryId);
//        model.addAttribute("country", country);
//        return "country";
//    }
//
//    @PostMapping(path = "/country")
//    public String saveCountry(Country country, Model model){
//        Long id = countryService.save(country);
//        model.addAttribute("countryId", id);
//        return "redirect:/country/{countryId}";
//    }

}
