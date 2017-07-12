package by.ecp.services;

import by.ecp.entity.Stage;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
public interface StageService {

    List<Stage> findAll();

    Stage findOne(Long id);

    void save(Stage stage);

}
