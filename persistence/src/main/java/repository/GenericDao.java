package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDao<T, K> {

    private EntityManagerFactory emf;
    protected final EntityManager em;
    protected final Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected GenericDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
        this.emf = Persistence.createEntityManagerFactory("examplePersistenceUnit");
        this.em = this.emf.createEntityManager();
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
}