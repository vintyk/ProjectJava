package by.dao;

import by.ecp.db.CompanyDao;
import by.ecp.db.CountryDao;
import by.ecp.entity.Company;
import by.ecp.entity.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Vinty on 11.06.2017.
 */
public class CompanyDaoTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void testGetCompany() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Company company = new Company();
        company.setNameCompany("США");
        session.save(company);

        CompanyDao companyDao = new CompanyDao();
        Company company1 = companyDao.findOne(1L);
        assertThat(company1, notNullValue());
        transaction.commit();
        session.close();
    }
    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}