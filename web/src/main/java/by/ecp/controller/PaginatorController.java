package by.ecp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by SystemUser on 28.06.2017.
 */
@Controller
@RequestMapping("/country")
public class PaginatorController {


    //    @RequestMapping("/{id}")
//    public String showCountryForm(@PathVariable("id") Country country, Model model) {
//        model.addAttribute("country", country);
//        return "country";
//    }

//    @Autowired CountryDao countryDao;
//
//    @RequestMapping
//    public String showCountryForm(Model model, Pageable pageable) {
//        model.addAttribute("country", countryDao.findAll());
//        Assert.notNull(pageable, "id must not be null!");
//        return "country";
//    }
}
