package by.ecp.services;

import by.ecp.db.PublicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Created by User on 11.07.2017.
 */
@Service
@Transactional
public class PublicationServiceImpl implements PublicationService {

    private final PublicationDao publicationDao;

    @Autowired
    public PublicationServiceImpl(PublicationDao publicationDao) {
        this.publicationDao = publicationDao;
    }

    @Override
    public void savePublication(
            String namePublication,
            String textPublication,
            Long gameId,
            LocalDate datePublication) {
    publicationDao.savePublication(
            namePublication,
            textPublication,
            gameId,
            datePublication);
    }
}
