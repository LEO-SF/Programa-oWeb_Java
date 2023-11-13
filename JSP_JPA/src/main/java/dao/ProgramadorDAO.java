package dao;

import classes.Programador;
import util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ProgramadorDAO {

    private EntityManager em;

    public ProgramadorDAO() {
    }

    public boolean salvar(Programador entity) {
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
            System.out.println("Falha ao salvar no método salvar na classe ProgramadorDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Programador entity) {
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
            System.out.println("Falha ao atualizar no método atualizar na classe ProgramadorDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Programador entity = em.find(Programador.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Falha ao atualizar no método atualizar na classe ProgramadorDAO" + e.getMessage());
            return false;
        }
    }

    public Programador buscarID(Long idProgramador) {
        try {
            em = JPAUtil.getEntityManager();
            Programador entity = em.find(Programador.class, idProgramador);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Falha ao buscar no método buscarID na classe ProgramadorDAO" + e.getMessage());
            return null;
        }
    }

    public List<Programador> buscarTodosProg() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Programador> query = em.createQuery("SELECT obj FROM Programador obj", Programador.class);
            List<Programador> Programadors = query.getResultList();
            return Programadors;
        } catch (RuntimeException e) {
        	System.out.println("Falha ao listar no método buscarTodosProg na classe ProgramadorDAO" + e.getMessage());
            return null;
        }
    }

}
