package by.ecp.db;

import by.ecp.entity.Gender;
import by.ecp.entity.Privilege;
import by.ecp.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * Created by User on 26.05.2017.
 */
public class ToolsDataBase {
    private static final Object LOCK = new Object();
    private static ToolsDataBase INSTANCE = null;

    public static ToolsDataBase getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ToolsDataBase();
                }
            }
        }
        return INSTANCE;
    }

    public boolean delStringFromDbById(Class<?> type, Serializable id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Object persistentInstance = session.get(type, id);
            if (persistentInstance != null) {
                session.delete(persistentInstance);
                transaction.commit();
                return true;
            } else {
                return false;
            }
        } catch (Throwable throwable) {
            transaction.rollback();
            System.out.println("Метод delStringFromDbById не нашел ни одной строки с Id = "+ id);
            throw throwable;
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    public void savePrivilege() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Privilege privilege1 = new Privilege();
        privilege1.setName("Admin");
        Privilege privilege2 = new Privilege();
        privilege2.setName("User");
        session.save(privilege1);
        session.save(privilege2);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
