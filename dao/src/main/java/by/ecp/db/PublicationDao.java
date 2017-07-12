package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Publication;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Vinty on 20.06.2017.
 */
public interface PublicationDao extends BaseDao<Publication> {

    void savePublication(
            String namePublication,
            String textPublication,
            Long gameId,
            LocalDate datePublication);

    List<Publication> findAllOrderDateDesc();
}
