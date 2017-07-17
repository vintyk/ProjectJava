package by.ecp.services;

import by.ecp.db.CommonBaseGameDao;
import by.ecp.entity.CommonBaseGame;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 17.07.2017.
 */
@Service
@Transactional
public class CommonBaseGameServiceImpl implements CommonBaseGameService{

    private  final CommonBaseGameDao commonBaseGameDao;

    public CommonBaseGameServiceImpl(CommonBaseGameDao commonBaseGameDao) {
        this.commonBaseGameDao = commonBaseGameDao;
    }

    @Override
    public void saveCommonBaseGame(String text, Long gameId) {
        commonBaseGameDao.saveCommonBaseGame(text, gameId);
    }

    @Override
    public List<CommonBaseGame> findAll() {
        return commonBaseGameDao.findAll();
    }
}
