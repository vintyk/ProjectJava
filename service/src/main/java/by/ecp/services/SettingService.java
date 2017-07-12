package by.ecp.services;

import by.ecp.entity.Setting;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
public interface SettingService {

    List<Setting> findAll();

    Setting findOne(Long id);

    void save(Setting setting);

}
