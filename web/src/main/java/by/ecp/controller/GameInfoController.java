package by.ecp.controller;

import by.ecp.dto.CommonBaseGameDto;
//import by.ecp.services.CommonBaseGameService;
import by.ecp.entity.Game;
import by.ecp.services.CommonBaseGameService;
import by.ecp.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("myGame")
    public Game game(){return new Game();}

    @ModelAttribute("games")
    public List<Game> games() {
        return gameService.findAll();
    }

    @ModelAttribute("commonGames")
    public List<CommonBaseGameDto> common_games() {
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


    @PostMapping(path = "/gameInfo/{gameId}")
    public String updateText(@PathVariable("gameId") Long gameId, Model model,
                             @RequestParam String text,
                             @RequestParam Long version) throws Exception {
        CommonBaseGameDto commonBaseGameDto = commonBaseGameService.findOneTextByGame(gameId);
        long versionComm = commonBaseGameDto.getVersion();
        if (versionComm != version) {
            return "VerError";
        }
        try {
            commonBaseGameDto.setText(text);
            commonBaseGameDto.setGameId(gameId);
            commonBaseGameService.update(commonBaseGameDto);
        } catch (Exception exception) {
            exception.printStackTrace();
            return "VerError";
        }
        List<CommonBaseGameDto> common_games = commonBaseGameService.findAllList();
        model.addAttribute("commonGames", common_games);
        return "GameInfo";
    }

    @GetMapping(path = "/gameInfo/{gameId}")
    public String updateGameViewAttr(@PathVariable("gameId") Long gameId, Model model) {
        CommonBaseGameDto  common_games = commonBaseGameService.findOneTextByGame(gameId);
        long version = common_games.getVersion();
        model.addAttribute("commonGames", common_games);
        model.addAttribute("version", version);
        return "GameInfo";
    }
}


