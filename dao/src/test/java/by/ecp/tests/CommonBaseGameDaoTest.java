package by.ecp.tests;

import by.ecp.db.*;
import by.ecp.entity.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.util.AssertionErrors.assertEquals;

/**
 * Created by User on 17.07.2017.
 */
public class CommonBaseGameDaoTest extends BaseTest {
    @Autowired
    private GameDao gameDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private GenreDao genreDao;
    @Autowired
    private PaymentModelDao paymentModelDao;
    @Autowired
    private SettingDao settingDao;
    @Autowired
    private StageDao stageDao;
    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private CommonBaseGameDao commonBaseGameDao;

    @Test
    public void findAllOrderDateDescTest() {
        Company company = new Company();
        company.setName("Valve");
        companyDao.save(company);
        Genre genre = new Genre();
        genre.setName("Гонки");
        genreDao.save(genre);
        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setName("Подписка");
        paymentModelDao.save(paymentModel);
        Setting setting = new Setting();
        setting.setName("Фэнтези");
        settingDao.save(setting);
        Stage stage = new Stage();
        stage.setName("Ранний доступ");
        stageDao.save(stage);

        Platform platform1 = new Platform();
        platform1.setName("X-Box");
        platformDao.save(platform1);
        Set<Long> platformLongs = new HashSet<>();
        platformLongs.add(1L);

        gameDao.saveGameToExistingPlatform(
                "Новая офигенная Игра",
                1L,
                1L,
                1L,
                1L,
                1L,
                platformLongs);
        commonBaseGameDao.saveCommonBaseGame(
                "dddddd",
                1L
        );
        List<CommonBaseGame> result = commonBaseGameDao.findAllList();
        Assert.assertEquals(result.size(), 1);

    }

}
