package by.ecp.common;

import by.ecp.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;

/**
 * Created by Vinty on 09.06.2017.
 */
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    protected SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    protected Session getCurrentSession() {return sessionFactory.getCurrentSession();}

    @Override
    public void  save(T entity){
        sessionFactory.getCurrentSession().save(entity);
    }
    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "FROM " + modelClass.getSimpleName(), modelClass)
                .getResultList();
    }
    @Override
    public T findOne(Long id) {
        Session session = sessionFactory.getCurrentSession();
        T result = session.get(modelClass, id);
        return result;
    }
    @Override
    public void  delete(T entity){
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }
    @Override
    public void update (T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(modelClass.getSimpleName(), entity);
    }
}
