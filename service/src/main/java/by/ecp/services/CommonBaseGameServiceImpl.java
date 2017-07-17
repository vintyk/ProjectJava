package by.ecp.services;

import by.ecp.db.CommonBaseGameDao;
import by.ecp.dto.CommonBaseGameDto;
import by.ecp.entity.CommonBaseGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 17.07.2017.
 */
@Service
@Transactional
public class CommonBaseGameServiceImpl implements CommonBaseGameService{

    private  final CommonBaseGameDao commonBaseGameDao;
    @Autowired
    public CommonBaseGameServiceImpl(CommonBaseGameDao commonBaseGameDao) {
        this.commonBaseGameDao = commonBaseGameDao;
    }

    @Override
    public void saveCommonBaseGame(String text, Long gameId) {
        commonBaseGameDao.saveCommonBaseGame(text, gameId);
    }

    @Override
    public List<CommonBaseGameDto> findAllList() {
        return commonBaseGameDao
                .findAllList()
                .stream()
                .map(game -> new CommonBaseGameDto(game.getText(), game.getId()))
                .collect(Collectors.toList());
    }
}
