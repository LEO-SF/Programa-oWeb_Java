package dao;

import classes.Hospede;
import classes.Quarto;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class QuartoDAO {
    private EntityManager em;

    public QuartoDAO() {
    }

    public boolean salvar(Quarto entity) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {

                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean atualizar(Quarto entity) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Quarto entity = em.find(Quarto.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public Quarto buscarID(int id) {
        try {
            em = JPAUtil.getEntityManager();
            Quarto entity = em.find(Quarto.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public List<Quarto> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Quarto> query = em.createQuery("SELECT obj FROM Quarto obj", Quarto.class);
            List<Quarto> Quartos = query.getResultList();
            return Quartos;
        } catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public Quarto buscarPorNumero(int num) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Quarto> query = em.createQuery("SELECT obj FROM Quarto obj WHERE obj.numero= :numero", Quarto.class);
            query.setParameter("numero", num);
            return query.getSingleResult();
        }catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
