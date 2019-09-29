package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T, K> {

    protected final EntityManager em;
    protected final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected GenericDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.em = JpaUtils.get();
    }

    public void create(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    public T read(K id) {
        return em.find(entityClass, id);
    }

    public T update(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        T merge = em.merge(entity);
        transaction.commit();
        return merge;
    }

    public void delete(K id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        T read = read(id);
        em.remove(read);
        transaction.commit();
    }

    public List<T> findAll() {
        List<T> allObjects = new ArrayList();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            allObjects = em.createQuery("Select t from " + entityClass.getSimpleName() + " t", entityClass).getResultList();
            transaction.commit();
            return allObjects;
        } catch (Exception e) {
            transaction.rollback();
            return null;
        }
    }



}