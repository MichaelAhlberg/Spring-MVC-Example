package info.ahlberg.spring.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDAOWithJPA<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> persistentClass;

    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDAOWithJPA() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void flush() {
        entityManager.flush();
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T loadById(ID id) {
        if (id == null) {
            return null;
        } else {
            return entityManager.find(persistentClass, id);
        }
    }

    public void persist(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
        entityManager.flush();
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    public List<T> loadAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t")
                .setHint("org.hibernate.cacheable", true).getResultList();
    }
}
