package dao;

import classes.Hospede;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
public class HospedeDAO {
    private EntityManager em;

    public HospedeDAO() {
    }

    public boolean salvar(Hospede entity) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            System.out.println("ok");
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Hospede entity) {
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
            Hospede entity = em.find(Hospede.class, id);
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

    public Hospede buscarID(int id) {
        try {
            em = JPAUtil.getEntityManager();
            Hospede entity = em.find(Hospede.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public List<Hospede> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Hospede> query = em.createQuery("SELECT obj FROM Hospede obj", Hospede.class);
            List<Hospede> Hospedes = query.getResultList();
            return Hospedes;
        } catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public Hospede buscarPorNome(String nome, String cpf) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Hospede> query = em.createQuery("SELECT obj FROM Hospede obj WHERE obj.nome = :nome AND obj.cpf = :cpf", Hospede.class);
            query.setParameter("nome", nome);
            query.setParameter("cpf", cpf);
            return query.getSingleResult();
        }catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
