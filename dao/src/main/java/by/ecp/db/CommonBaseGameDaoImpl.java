package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.CommonBaseGame;
import by.ecp.entity.Game;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vinty on 05.06.2017.
 */
@Repository
public class CommonBaseGameDaoImpl extends BaseDaoImpl<CommonBaseGame> implements CommonBaseGameDao{

    @Autowired
    CommonBaseGameDao commonBaseGameDao;

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

    @Override
    public List<CommonBaseGame> listCommonBaseGame() {
        return commonBaseGameDao.findAll();
    }
}
