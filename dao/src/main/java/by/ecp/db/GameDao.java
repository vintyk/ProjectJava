package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Game;

import java.util.List;
import java.util.Set;

/**
 * Created by SystemUser on 20.06.2017.
 */
public interface GameDao extends BaseDao<Game> {

    List<Game> getGameList();
//
//    void saveGame(String nameGame,
//                  Long companyId,
//                  Long genreId,
//                  Long paymentModelId,
//                  Long settingId,
//                  Long stageId);

    void saveGameToExistingPlatform(String nameGame,
                                    Long companyId,
                                    Long genreId,
                                    Long paymentModelId,
                                    Long settingId,
                                    Long stageId,
                                    Set<Long> platformsIDs
    );
}
