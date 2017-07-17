package by.ecp.tests;

import by.ecp.entity.Company;
import by.ecp.entity.Stage;
import by.ecp.services.CompanyService;
import by.ecp.services.StageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 11.07.2017.
 */
public class StageServiceTest extends BaseTest{
    @Autowired
    private StageService stageService;
    @Test
    public void findAll(){
        Stage stage = new Stage();
        stage.setName("ggga");
        stageService.save(stage);
        List<Stage> stageList = stageService.findAll();
        assertThat(stageList, notNullValue());
        Stage stage1 = stageService.findOne(1L);
        assertThat(stage1, notNullValue());
    }
}
