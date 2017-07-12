package by.ecp.services;

import by.ecp.db.GenreDao;
import by.ecp.entity.Genre;
import by.ecp.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by User on 07.07.2017.
 */
@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Autowired
    public GenreServiceImpl (GenreDao genreDao){
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public void save(Genre genre) {
        genreDao.save(genre);
    }

    @Override
    public Genre findOne(Long id) {
        return genreDao.findOne(id);
    }
}
