package by.ecp.tests;

import by.ecp.TestConfig;
import by.ecp.common.BaseDaoImpl;
import by.ecp.db.*;
import by.ecp.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by SystemUser on 16.06.2017.
 */
public class GameDaoTest extends BaseTest{
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
        List<Game> result = gameDao.getGameList();
        System.out.println(result);
        assertNotNull(result);
        assertThat(result, hasSize(1));
    }
}

