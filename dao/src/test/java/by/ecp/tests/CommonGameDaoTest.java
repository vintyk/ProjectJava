package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.*;
import by.ecp.entity.*;
import by.ecp.tests.BaseDaoTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Vinty on 11.06.2017.
 */

public class CommonGameDaoTest extends BaseTest{
    @Autowired
    private CommonBaseGameDao commonBaseGameDao;
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
    private BaseDao<CommonBaseGame> dao = new CommonBaseGameDaoImpl();

    @Test
    public void saveByExistPlatformsTest() {
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
        Platform platform2 = new Platform();
        platform2.setName("PC");
        platformDao.save(platform2);
        Set<Long> platformLongs = new HashSet<>();
        platformLongs.add(1L);
        platformLongs.add(2L);

        gameDao.saveGameToExistingPlatform(
                "Новая офигенная Игра",
                1L,
                1L,
                1L,
                1L,
                1L,
                platformLongs);
        Game game = gameDao.findOne(1L);
        CommonBaseGame commonBaseGame = new CommonBaseGame();
        commonBaseGame.setGame(game);
        commonBaseGame.setText("ggggggggggggggggggggggggg");
        List<CommonBaseGame> result = commonBaseGameDao.findAll();
        assertNotNull(result);
    }
}
