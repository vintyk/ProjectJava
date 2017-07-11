package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by SystemUser on 09.06.2017.
 */
@Repository
public class PublicationDaoImpl extends BaseDaoImpl<Publication> implements PublicationDao{

    @Override
    public void savePublication(
            String namePublication,
            String textPublication,
            Long gameId,
            LocalDate datePublication) {
        Session session = getSessionFactory().getCurrentSession();

        Game game = new Game();
        game.setId(gameId);

        Publication publication = new Publication();
        publication.setNamePublication(namePublication);
        publication.setText(textPublication);
        publication.setDatePublication(datePublication);
        publication.setGame(game);
        session.save(publication);
    }
    @Override
    public List<Publication> findAllOrderDateDesc() {
        Session session = getSessionFactory().getCurrentSession();
        QPublication publication = new QPublication("myPublication");
        JPAQuery<Publication> query = new JPAQuery<>(session);
        query
                .select(publication)
                .from(publication)
                .orderBy(publication.datePublication.desc());
        return query.fetchResults().getResults();
    }
}
