package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import lombok.EqualsAndHashCode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Vinty on 05.06.2017.
 */
@Repository
@EqualsAndHashCode
public class GameDaoImpl extends BaseDaoImpl<Game> implements GameDao{

    @Override
    public List<Game> getGameList() {
        List<Game> resultSetGame = getSessionFactory()
                .getCurrentSession()
                .createQuery("from Game ", Game.class)
                .getResultList();
        return resultSetGame;
    }

    @Override
    public void saveGameToExistingPlatform(String nameGame,
                                           Long companyId,
                                           Long genreId,
                                           Long paymentModelId,
                                           Long settingId,
                                           Long stageId,
                                           Set<Long> platformsIDs
                                           ){
        Session session = getSessionFactory().getCurrentSession();

        Company company = new Company();
        company.setId(companyId);

        Genre genre = new Genre();
        genre.setId(genreId);

        PaymentModel paymentModel = new PaymentModel();
        paymentModel.setId(paymentModelId);

        Setting setting = new Setting();
        setting.setId(settingId);

        Stage stage = new Stage();
        stage.setId(stageId);

        Set<Platform> platformSet = new HashSet<>();
        Iterator iter = platformsIDs.iterator();
        while (iter.hasNext()){
            Platform platform = session.get(Platform.class, (Serializable) iter.next());
            platformSet.add(platform);
            platformSet.forEach(System.out::println);
        }
        Game game = new Game();
        game.setNameGame(nameGame);
        game.setCompany(company);
        game.setGenre(genre);
        game.setPaymentModel(paymentModel);
        game.setSetting(setting);
        game.setStage(stage);
        game.setPlatforms(platformSet);
        session.save(game);
    }
}
