package by.ecp.controller;

import by.ecp.db.CountryDao;
import by.ecp.entity.Country;
import com.mysema.commons.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
