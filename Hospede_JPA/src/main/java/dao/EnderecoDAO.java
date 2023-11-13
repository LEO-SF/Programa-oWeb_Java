package dao;

import classes.Endereco;
import classes.Hospede;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class EnderecoDAO {

    private EntityManager em;

    public EnderecoDAO() {
    }

    public boolean salvar(Endereco entity) {
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

    public boolean atualizar(Endereco entity) {
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
            Endereco entity = em.find(Endereco.class, id);
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

    public Endereco buscarID(int id) {
        try {
            em = JPAUtil.getEntityManager();
            Endereco entity = em.find(Endereco.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public List<Endereco> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Endereco> query = em.createQuery("SELECT obj FROM Endereco obj", Endereco.class);
            List<Endereco> Enderecos = query.getResultList();
            return Enderecos;
        } catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public Endereco buscarPorLogradouro(String logradouro, String complemento) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Endereco> query = em.createQuery("SELECT obj FROM Endereco obj WHERE obj.logradouro = :logradouro AND obj.complemento = :complemento", Endereco.class);
            query.setParameter("logradouro", logradouro);
            query.setParameter("complemento", complemento);
            return query.getSingleResult();
        } catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }
}