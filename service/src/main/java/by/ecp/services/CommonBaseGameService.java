package by.ecp.services;

import by.ecp.entity.CommonBaseGame;

import java.util.List;

/**
 * Created by User on 17.07.2017.
 */
public interface CommonBaseGameService {

    List<CommonBaseGame> listCommonBaseGame();

    void saveCommonBaseGame(
            String text,
            Long gameId);
}
