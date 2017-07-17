package by.ecp.controller;

import by.ecp.dto.CommonBaseGameDto;
import by.ecp.entity.CommonBaseGame;
//import by.ecp.services.CommonBaseGameService;
import by.ecp.entity.Game;
import by.ecp.services.CommonBaseGameService;
import by.ecp.services.GameService;
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

    private final CommonBaseGameService commonBaseGameService;
    private final GameService gameService;

    @Autowired
    public GameInfoController(CommonBaseGameService commonBaseGameService, GameService gameService) {
        this.commonBaseGameService = commonBaseGameService;
        this.gameService = gameService;
    }
    @ModelAttribute("games")
    public List<Game> games(){
        return gameService.findAll();
    }

    @ModelAttribute("commonGames")
    public List<CommonBaseGameDto> common_games(){
        return commonBaseGameService.findAllList();
    }
    @ModelAttribute("commonBaseGameDto")
    public CommonBaseGameDto commonBaseGameDto() {
        return new CommonBaseGameDto();
    }

    @GetMapping(path = "/gameInfo")
    public String showGameViewForm() {
        return "GameInfo";
    }

    @PostMapping(path = "/gameInfo")
    public String tempGameDto(CommonBaseGameDto commonBaseGameDto, Model model){

        return "/GameInfo";
    }
}
