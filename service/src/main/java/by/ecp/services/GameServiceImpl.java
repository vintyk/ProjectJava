package by.ecp.services;

import by.ecp.db.GameDao;
import by.ecp.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

/**
 * Created by Vinty on 07.07.2017.
 */
@Transactional
@Service
public class GameServiceImpl implements GameService {

    private final GameDao gameDao;

    @Autowired
    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    @Loggable
    public List<Game> findAll() {
        return gameDao.findAll();
    }
    @Override
    @LoggableOne
    public Game findById(Long id) {
        return gameDao.findOne(id);
    }
    @Override
    @LoggableOne
    public void saveGameToExistingPlatform(
                     String nameGame,
                     Long company,
                     Long genre,
                     Long paymentModel,
                     Long setting,
                     Long stage,
                     Set<Long> platformSet) {
       gameDao.saveGameToExistingPlatform(
               nameGame,
               company,
               genre,
               paymentModel,
               setting,
               stage,
               platformSet
       );
    }
}
