package by.ecp.tests;

import by.ecp.dto.CommonBaseGameDto;
import by.ecp.dto.GameDto;
import by.ecp.dto.PublicationDto;
import by.ecp.entity.*;
import by.ecp.services.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 17.07.2017.
 */
public class CommonBaseGameServiceTest extends BaseTest {

    @Autowired
    CommonBaseGameService commonBaseGameService;
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
    public void saveCommonBaseGameServiceTest() {
        PublicationDto publicationDto = new PublicationDto();
        publicationDto.setNamePublication("fffff");
        publicationDto.setText("gggggghhhhhjjjjj");
        publicationDto.setGameId(1L);

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
        String text = "ggggggg";
        commonBaseGameService.saveCommonBaseGame(text, 1L);
        List<CommonBaseGameDto> result = commonBaseGameService.findAllList();
        System.out.println("---------------"+result);
        System.out.println("===================="+ commonBaseGameService.findOneTextByGame(1L));
        assertEquals(result.size(), 1);

        String text2 = "AAAAAAA";
        commonBaseGameService.saveCommonBaseGame(text2, 1L);
        System.out.println("===================="+commonBaseGameService.findOneTextByGame(1L));
        List<CommonBaseGameDto> resultAll = commonBaseGameService.findAllList();
        assertEquals(resultAll.size(), 2);
    }
    @Test
    public void updateCommonBaseGameServiteTest() {
        PublicationDto publicationDto = new PublicationDto();
        publicationDto.setNamePublication("fffff");
        publicationDto.setText("gggggghhhhhjjjjj");
        publicationDto.setGameId(1L);

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
        company.setName("vvv");
        companyService.save(company);
        Genre genre = new Genre();
        genre.setName("jjj");
        genreService.save(genre);
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("bbbb");
        paymentModelService.save(paymentModel);
        Setting setting = new Setting();
        setting.setName("bbvb");
        settingService.save(setting);
        Stage stage = new Stage();
        stage.setName("xxx");
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
        String text1 = "AAA";
        commonBaseGameService.saveCommonBaseGame(text1, 1L);
        CommonBaseGameDto result = commonBaseGameService.findOneTextByGame(1L);
        assertEquals(result.getText(), "AAA");

//        result.setText("BBB");
//        result.setGameId(1L);
//        commonBaseGameService.update(result);
//        assertEquals(result.getText(), "BBB");

    }
}
