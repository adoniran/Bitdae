/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

/**
 *
 * @author adoniran
 */
public abstract class CrudGenerico<T> {

    private Class<T> entityClass;

    public CrudGenerico(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @PersistenceContext(unitName = "BitdaePU")
    private EntityManager em;

    public EntityManager getGerente() {
        return this.em;
    }

    public void criar(@NotNull T entity) {
        em.persist(entity);
    }

    public void editar(T entity) {
        em.merge(entity);
    }

    public void remover(T entity) {
        em.remove(em.merge(entity));
    }

}
