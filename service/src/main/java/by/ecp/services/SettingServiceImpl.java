package by.ecp.services;

import by.ecp.db.SettingDao;
import by.ecp.entity.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
@Transactional
@Service
public class SettingServiceImpl implements SettingService {

    private final SettingDao settingDao;

    @Autowired
    public SettingServiceImpl(SettingDao settingDao) {
        this.settingDao = settingDao;
    }

    @Override
    @Loggable
    public List<Setting> findAll() {
        return settingDao.findAll();
    }

    @Override
    @LoggableOne
    public Setting findOne(Long id) {
        return settingDao.findOne(id);
    }

    @Override
    @Loggable
    public void save(Setting setting) {
        settingDao.save(setting);
    }
}
