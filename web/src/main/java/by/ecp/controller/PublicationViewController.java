package by.ecp.controller;

import by.ecp.entity.Game;
import by.ecp.entity.Publication;
import by.ecp.services.PublicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping(path = "/publication_view/{title}")
//    public String showPublicationPage(@PathVariable("title") String title,
//                                 @RequestParam("page") int page, Model model) {
//        int sizePage = 3;
//        model.addAttribute("page", page);
//        model.addAttribute("sizePage", sizePage);
//        model.addAttribute("countPage", Math.ceil(
//                publicationService.countByPublicationId(
//                        publicationService.findByName(title).getId()) / (double)sizePage));
//        return "PublicationView";
//    }

    @PostMapping(path = "/publication_view")
    public String tempPublicationDto(Model model){
        return "/PublicationView";
    }
}
