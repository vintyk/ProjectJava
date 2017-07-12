package by.ecp.tests;

import by.ecp.entity.Company;
import by.ecp.entity.Setting;
import by.ecp.services.CompanyService;
import by.ecp.services.SettingService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class SettingServiceTest extends BaseTest{
    @Autowired
    private SettingService settingService;
    @Test
    public void findAll(){
        Setting setting = new Setting();
        setting.setName("a");
        settingService.save(setting);
        List<Setting> settingList= settingService.findAll();
        assertThat(settingList, notNullValue());
        Setting setting1 = settingService.findOne(1L);
        assertThat(setting1, notNullValue());
    }
}
