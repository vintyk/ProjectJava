package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.GameAdditionGoods;
import by.ecp.entity.QGameAdditionGoods;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vinty on 14.07.2017.
 */
@Repository
public class GameAdditionGoodsDaoImpl extends BaseDaoImpl<GameAdditionGoods> implements GameAdditionGoodsDao{

    @Autowired
    private GameAdditionGoodsDao gameAdditionGoodsDao;

    @Override
    public GameAdditionGoods findOne(GameAdditionGoods gameAdditionGoods) {
        Session session = getSessionFactory().getCurrentSession();
        QGameAdditionGoods qGameAdditionGoods = new QGameAdditionGoods("myGameExcl");
        JPAQuery<GameAdditionGoods> query = new JPAQuery<>(session);
        query.select(qGameAdditionGoods)
                .from(qGameAdditionGoods)
                .where(qGameAdditionGoods.eq(gameAdditionGoods));
        GameAdditionGoods result = query.fetchOne();
        session
                .getTransaction()
                .commit();
        return result;
    }

    @Override
    public GameAdditionGoods save() {
        return gameAdditionGoodsDao.save();
    }
}
