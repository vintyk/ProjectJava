package by.ecp.services;

import by.ecp.db.StageDao;
import by.ecp.entity.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
@Transactional
@Service
public class StageServiceImpl implements StageService {

    private final StageDao stageDao;

    @Autowired
    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public List<Stage> findAll() {
        return stageDao.findAll();
    }

    @Override
    public Stage findOne(Long id) {
        return stageDao.findOne(id);
    }

    @Override
    public void save(Stage stage) {
        stageDao.save(stage);
    }
}
