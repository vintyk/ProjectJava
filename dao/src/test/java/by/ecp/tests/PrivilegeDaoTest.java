package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.PrivilegeDaoImpl;
import by.ecp.entity.Privilege;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SystemUser on 16.06.2017.
 */
public class PrivilegeDaoTest extends BaseDaoTest<Privilege> {
    @Autowired
    private BaseDao<Privilege> dao = new PrivilegeDaoImpl();

    @Override
    protected BaseDao<Privilege> getDao() {
        return dao;
    }

    @Override
    protected Privilege getModel() {
        return new Privilege();
    }
}
