package by.ecp.services;

import java.time.LocalDate;

/**
 * Created by User on 11.07.2017.
 */
public interface PublicationService {

    void savePublication(
            String namePublication,
            String textPublication,
            Long gameId,
            LocalDate datePublication);
}
