package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.CommonBaseGame;

import java.util.List;

/**
 * Created by User on 17.07.2017.
 */
public interface CommonBaseGameDao extends BaseDao<CommonBaseGame>{

    void saveCommonBaseGame (String text, Long gameId);

    List<CommonBaseGame> findAllList();
}
