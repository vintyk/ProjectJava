package by.ecp.controller;

import by.ecp.entity.Game;
import by.ecp.entity.Publication;
import by.ecp.services.PublicationService;
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
public class PublicationViewController {

    private final PublicationService publicationService;

    public PublicationViewController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @ModelAttribute("publications")
    public List<Publication> publications(){
        return publicationService.findAllOrderDateDesc();
    }

    @GetMapping(path = "/publication_view")
    public String showPublicationViewForm() {
        return "PublicationView";
    }

    @PostMapping(path = "/publication_view")
    public String tempPublicationDto(Model model){
        return "/PublicationView";
    }
}
