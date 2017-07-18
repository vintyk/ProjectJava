package by.ecp.services;

import by.ecp.db.CommonBaseGameDao;
import by.ecp.db.GameDao;
import by.ecp.dto.CommonBaseGameDto;
import by.ecp.entity.CommonBaseGame;
import by.ecp.entity.Game;
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
    private  final GameDao gameDao;
    @Autowired
    public CommonBaseGameServiceImpl(CommonBaseGameDao commonBaseGameDao, GameDao gameDao) {
        this.commonBaseGameDao = commonBaseGameDao;
        this.gameDao = gameDao;
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
                .map(game -> new CommonBaseGameDto(game.getText(), game.getId(), game.getVersion()))
                .collect(Collectors.toList());
    }

    @Override
    public CommonBaseGameDto findOneTextByGame(Long id){
        CommonBaseGame commonBaseGame = commonBaseGameDao.findAllTextByGameId(id);
        CommonBaseGameDto commonBaseGameDto = new CommonBaseGameDto();
        commonBaseGameDto.setText(commonBaseGame.getText());
        commonBaseGameDto.setGameId(commonBaseGame.getId());
        commonBaseGameDto.setVersion(commonBaseGame.getVersion());
        return commonBaseGameDto;
    }

    @Override
    public void update(CommonBaseGameDto commonBaseGameDto) {
        CommonBaseGame commonBaseGame = new CommonBaseGame();
        Game game = gameDao.findOne(commonBaseGameDto.getGameId());

        commonBaseGame.setText(commonBaseGameDto.getText());
        commonBaseGame.setGame(game);
//        commonBaseGame.setVersion(commonBaseGameDto.getVersion());
        commonBaseGameDao.update(commonBaseGame);
    }
}
