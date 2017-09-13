package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.RankDaoImpl;
import by.ecp.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SystemUser on 16.06.2017.
 */
public class RankDaoTest extends BaseDaoTest<Rank> {

    @Autowired
    private BaseDao<Rank> dao = new RankDaoImpl();

    @Override
    protected BaseDao<Rank> getDao() {
        return dao;
    }
    @Override
    protected Rank getModel() {
        return new Rank();
    }
}
