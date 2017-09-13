package by.ecp.services;

import by.ecp.entity.Vacancy;

import java.util.List;

/**
 * Created by SystemUser on 28.06.2017.
 */
public interface VacancyService {

    List<Vacancy> findAll();

    Vacancy findOne(Long id);

    void save(Vacancy vacancy);
}
