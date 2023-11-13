package dao;

import classes.Hospede;
import classes.Reserva;
import util.JPAUtil;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReservaDAO {

    private EntityManager em;

    public ReservaDAO() {
    }

    public boolean salvar(Reserva entity) {
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

    public boolean atualizar(Reserva entity) {
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
            Reserva entity = em.find(Reserva.class, id);
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

    public Reserva buscarID(Long idReserva) {
        try {
            em = JPAUtil.getEntityManager();
            Reserva entity = em.find(Reserva.class, idReserva);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public List<Reserva> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Reserva> query = em.createQuery("SELECT obj FROM Reserva obj", Reserva.class);
            List<Reserva> Reservas = query.getResultList();
            return Reservas;
        } catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public Reserva buscarIdPessoa(Long reserva, Long pessoa) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Reserva> query = em.createQuery("SELECT obj FROM Reserva obj JOIN obj.hospede h WHERE obj.idReserva = :idReserva AND h.idPessoa = :idPessoa", Reserva.class);
            query.setParameter("idReserva", reserva);
            query.setParameter("idPessoa", pessoa);
            return query.getSingleResult();
        }catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
