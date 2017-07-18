package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.CommonBaseGame;
import by.ecp.entity.Game;
import by.ecp.entity.QCommonBaseGame;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<CommonBaseGame> findAllList() {
        Session session = getSessionFactory().getCurrentSession();
        QCommonBaseGame commonBaseGame = new QCommonBaseGame("myCommBaseGame");
        JPAQuery<CommonBaseGame> query = new JPAQuery<>(session);
        query
                .select(commonBaseGame)
                .from(commonBaseGame);
        return query.fetchResults().getResults();
    }
    @Override
    public CommonBaseGame findAllTextByGameId(Long gameId){
        QCommonBaseGame commonBaseGame = new QCommonBaseGame("myQComm");
        JPAQuery<CommonBaseGame> query = new JPAQuery<>(getCurrentSession());
        query
                .select(commonBaseGame)
                .from(commonBaseGame)
                .join(commonBaseGame.game)
                .where(commonBaseGame.game.id.eq(gameId))
                .limit(1)
                .orderBy(commonBaseGame.game.id.desc());
        return query.fetchOne();
    }

}
