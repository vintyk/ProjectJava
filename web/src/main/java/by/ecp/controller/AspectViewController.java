package by.ecp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by User on 13.07.2017.
 */
@Controller
public class AspectViewController {

    @GetMapping("/aspect")
    @ResponseBody
    public String aspectView(){
        return "Если ты это видишь, то ты молодец.";
    }
}
