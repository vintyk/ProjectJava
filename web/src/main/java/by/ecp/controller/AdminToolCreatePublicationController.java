package by.ecp.controller;

import by.ecp.dto.PublicationDto;
import by.ecp.entity.Game;
import by.ecp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
@Controller
public class AdminToolCreatePublicationController {

    private final PublicationService publicationService;
    private final GameService gameService;

    @Autowired
    public AdminToolCreatePublicationController(PublicationService publicationService, GameService gameService) {
        this.publicationService = publicationService;
        this.gameService = gameService;
    }
    @ModelAttribute("games")
    public List<Game> games(){
        return gameService.findAll();
    }

    @ModelAttribute("publicationDto")
    public PublicationDto publicationDto() {
        return new PublicationDto();
    }

    @GetMapping("/adminToolCreatePublication")
    public String showCreateGamePage() {
        return "AdminToolCreatePublication";
    }

    @PostMapping("/adminToolCreatePublication")
    public String tempGamePublicationDtoPage(PublicationDto publicationDto, Model model) {
        LocalDate localDate = LocalDate.now();
        publicationService.savePublication(
                publicationDto.getNamePublication(),
                publicationDto.getText(),
                publicationDto.getGameId(),
                localDate
        );
        return "AdminToolCreatePublication";
    }
}
