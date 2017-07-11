package by.ecp.services;

import by.ecp.entity.Publication;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by User on 11.07.2017.
 */
public interface PublicationService {

    void savePublication(
            String namePublication,
            String textPublication,
            Long gameId,
            LocalDate datePublication);
    List<Publication> findAllOrderDateDesc();
}
