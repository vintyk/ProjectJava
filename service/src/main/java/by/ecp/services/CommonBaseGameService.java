package by.ecp.services;

import by.ecp.dto.CommonBaseGameDto;
import by.ecp.entity.CommonBaseGame;

import java.util.List;

/**
 * Created by User on 17.07.2017.
 */
public interface CommonBaseGameService {

    void saveCommonBaseGame(
            String text,
            Long gameId);
    List<CommonBaseGameDto> findAllList();
}
