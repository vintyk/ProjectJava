package by.ecp.controller;

import by.ecp.entity.Game;
import by.ecp.services.GameService;
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
public class GameViewController {

    private final GameService gameService;

    public GameViewController(GameService gameService) {
        this.gameService = gameService;
    }

    @ModelAttribute("games")
    public List<Game> games(){
        return gameService.findAll();
    }

    @GetMapping(path = "/GameView")
    public String showGameViewForm() {
        return "GameView";
    }

    @PostMapping(path = "/GameView")
    public String tempGameDto(Model model){
        return "/GameView";
    }
}
