package by.ecp.services;

import by.ecp.entity.Genre;
import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
public interface GenreService {

    Genre findOne(Long id);

    List<Genre> findAll();

    void save(Genre genre);

}
