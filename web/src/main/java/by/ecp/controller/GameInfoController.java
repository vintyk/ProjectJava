package by.ecp.controller;

import by.ecp.dto.CommonBaseGameDto;
import by.ecp.dto.JobVacancyDto;
import by.ecp.entity.CommonBaseGame;
//import by.ecp.services.CommonBaseGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by Vinty on 09.07.2017.
 */
@Controller
public class GameInfoController {

//    private final CommonBaseGameService commonBaseGameService;

//    @Autowired
//    public GameInfoController(CommonBaseGameService commonBaseGameService) {
//        this.commonBaseGameService = commonBaseGameService;
//    }

//    @ModelAttribute("CommonBaseGameDto")
//    public CommonBaseGameDto commonBaseGameDto() {
//        return new CommonBaseGameDto();
//    }
//    @ModelAttribute("games_info")
//    public List<CommonBaseGame> games_info(){
//        return commonBaseGameService.findAll();
//    }

    @GetMapping(path = "/gameInfo")
    public String showGameViewForm() {
        return "GameInfo";
    }

    @PostMapping(path = "/gameInfo")
    public String tempGameDto(Model model){
        return "/GameInfo";
    }
}
