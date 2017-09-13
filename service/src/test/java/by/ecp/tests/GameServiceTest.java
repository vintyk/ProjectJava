package by.ecp.tests;

import by.ecp.dto.GameDto;
import by.ecp.entity.*;
import by.ecp.services.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class GameServiceTest extends BaseTest {

    @Autowired
    private GameService gameService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private PaymentModelService paymentModelService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private StageService stageService;

    @Test
    public void saveGameToExistingPlatform(){
        GameDto gameDto = new GameDto();
        gameDto.setNameGame("a");
        gameDto.setCompanyId(1L);
        gameDto.setGenreId(1L);
        gameDto.setPaymentModelId(1L);
        gameDto.setSettingId(1L);
        gameDto.setStageId(1L);
        gameDto.setPlatformsId(1L);
        Set<Long> platformSet = new HashSet<>();
        platformSet.add(1L);
        Company company = new Company();
        companyService.save(company);
        Genre genre = new Genre();
        genreService.save(genre);
        PaymentModel paymentModel = new PaymentModel();
        paymentModelService.save(paymentModel);
        Setting setting = new Setting();
        settingService.save(setting);
        Stage stage = new Stage();
        stageService.save(stage);
        gameService.saveGameToExistingPlatform(
                gameDto.getNameGame(),
                gameDto.getCompanyId(),
                gameDto.getGenreId(),
                gameDto.getPaymentModelId(),
                gameDto.getSettingId(),
                gameDto.getStageId(),
                platformSet
        );
        Game game = gameService.findById(1L);
        assertThat(game, notNullValue());
        List<Game> gameList = gameService.findAll();
        assertThat(gameList, notNullValue());
    }
}


