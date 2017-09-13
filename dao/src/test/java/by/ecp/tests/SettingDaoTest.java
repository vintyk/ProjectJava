package by.ecp.tests;

import by.ecp.common.BaseDao;
import by.ecp.db.SettingDaoImpl;
import by.ecp.entity.Setting;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SystemUser on 16.06.2017.
 */
public class SettingDaoTest extends BaseDaoTest<Setting> {

    @Autowired
    private BaseDao<Setting> dao = new SettingDaoImpl();

    @Override
    protected BaseDao<Setting> getDao() {
        return dao;
    }
    @Override
    protected Setting getModel() {
        return new Setting();
    }
}
