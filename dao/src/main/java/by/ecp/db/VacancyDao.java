package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.Vacancy;

/**
 * Created by Vinty on 20.06.2017.
 */
public interface VacancyDao extends BaseDao<Vacancy> {

    void saveVacancy(String nameVacancy, Long companiesId);

    Vacancy findByName(String name);
}
