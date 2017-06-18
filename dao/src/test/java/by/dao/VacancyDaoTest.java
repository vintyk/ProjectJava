package by.dao;


import by.ecp.db.CompanyDao;
import by.ecp.db.VacancyDao;
import by.ecp.entity.Company;
import by.ecp.entity.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Vinty on 18.06.2017.
 */
public class VacancyDaoTest {
//    private static SessionFactory SESSION_FACTORY;
//     @BeforeClass
//    public static void init() {
//        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
//    }

//    @Test
//    public void testGetCompany() {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        Company company = new Company();
//        company.setNameCompany("США");
//        session.save(company);
//
//        VacancyDao vacancyDao = new VacancyDao();
//
//        vacancyDao.saveVacancy("TestVacancy", 1L, session);
//        System.out.println();
//        transaction.commit();
//        session.close();
//    }
    @Test
    public void getByNameTest(){
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
        VacancyDao vacancyDao = new VacancyDao();
        CompanyDao companyDao = new CompanyDao();
        Vacancy vacancy = new Vacancy();
        Company company = new Company();
        company.setNameCompany("My-new-Company");
        companyDao.save(company);
        vacancy.setNameVacancy("vac");
        vacancy.setCompany(company);
        vacancyDao.save(vacancy);

        Vacancy result = vacancyDao.findByName("vac", session);
        System.out.println(result);
//        transaction.commit();
//        session.close();
    }
//    @AfterClass
//    public static void finish() {
//        SESSION_FACTORY.close();
//    }
}
