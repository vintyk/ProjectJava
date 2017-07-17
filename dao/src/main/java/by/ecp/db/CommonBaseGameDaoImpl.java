package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.CommonBaseGame;
import by.ecp.entity.Game;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by User on 17.07.2017.
 */
@Repository
public class CommonBaseGameDaoImpl extends BaseDaoImpl<CommonBaseGame> implements CommonBaseGameDao {

    @Override
    public void saveCommonBaseGame(String text, Long gameId) {
        Session session = getSessionFactory().getCurrentSession();
        Game game = new Game();
        game.setId(gameId);

        CommonBaseGame commonBaseGame = new CommonBaseGame();
        commonBaseGame.setText(text);
        commonBaseGame.setGame(game);
        session.save(commonBaseGame);
    }
}
