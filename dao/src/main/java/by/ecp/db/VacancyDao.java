package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Vacancy;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by SystemUser on 20.06.2017.
 */
public interface VacancyDao extends BaseDao<Vacancy> {

    void saveVacancy(String nameVacancy, Long companiesId);

    Vacancy findByName(String name);
}
