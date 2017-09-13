package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import by.ecp.entity.Game;
import by.ecp.entity.Publication;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Vinty on 09.06.2017.
 */
@Repository
public class PublicationDaoImpl extends BaseDaoImpl<Publication> implements PublicationDao {

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

    @Override
    public int countById(Long id) {
        QPublication publication = new QPublication("public");
        Session session = getSessionFactory().getCurrentSession();
        JPAQuery<Publication> query = new JPAQuery<>(session);
        query.select(publication)
                .from(publication)
                .join(publication.game)
                .where(publication.game.id.eq(id))
                .orderBy(publication.datePublication.desc());
        List<Publication> results = query.fetchResults().getResults();
        int size = results.size();
        return size;
    }

    @Override
    public List<Publication> findPageById(Long id, int page, int sizePage) {
        List<Publication> publicationList = getSessionFactory().getCurrentSession().createQuery(
                "SELECT p FROM publications p WHERE p.game.id=:id", Publication.class)
                .setParameter("id", id)
                .setFirstResult(sizePage * (page - 1))
                .setMaxResults(sizePage)
                .getResultList();
        return publicationList.size() > 0 ? publicationList : null;
    }
}
