package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.GameAdditionGoods;

/**
 * Created by Vinty on 14.07.2017.
 */
public interface GameAdditionGoodsDao extends BaseDao<GameAdditionGoods> {
    GameAdditionGoods findOne(GameAdditionGoods gameAdditionGoods);
    GameAdditionGoods save();
}
