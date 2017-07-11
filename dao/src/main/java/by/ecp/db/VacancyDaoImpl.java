package by.ecp.db;

import by.ecp.common.BaseDaoImpl;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SystemUser on 02.06.2017.
 */
@Repository
public class VacancyDaoImpl extends BaseDaoImpl<Vacancy> implements VacancyDao{

    @Override
    public void saveVacancy(String nameVacancy, Long companiesId) {
        Session session = getSessionFactory().getCurrentSession();

        Company company = new Company();
        company.setId(companiesId);

        Vacancy vacancy = new Vacancy();
        vacancy.setNameVacancy(nameVacancy);
        vacancy.setCompany(company);
        session.save(vacancy);
    }

    @Override
    public Vacancy findByName(String name){
        Session session = getSessionFactory().getCurrentSession();
        QVacancy vacancy = new QVacancy("myNewVacancy");
        JPAQuery<Vacancy> query = new JPAQuery<>(session);
        query.select(vacancy).from(vacancy).where(vacancy.nameVacancy.eq(name));
        Vacancy result = query.fetchOne();
        return result;
    }
}
