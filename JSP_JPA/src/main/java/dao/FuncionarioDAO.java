package dao;

import classes.Funcionario;
import util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class FuncionarioDAO {

    private EntityManager em;

    public FuncionarioDAO() {
    }

    public boolean salvar(Funcionario entity) {
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
            System.out.println("Falha ao salvar no método salvar na classe FuncionarioDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Funcionario entity) {
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
            System.out.println("Falha ao autalizar no método atualizar na classe FuncionarioDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Funcionario entity = em.find(Funcionario.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Falha ao remover no método remover na classe FuncionarioDAO" + e.getMessage());
            return false;
        }
    }

    public Funcionario buscarID(Long idFuncionario) {
        try {
            em = JPAUtil.getEntityManager();
            Funcionario entity = em.find(Funcionario.class, idFuncionario);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Falha ao buscar no método buscarID na classe FuncionarioDAO" + e.getMessage());
            return null;
        }
    }

    public List<Funcionario> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Funcionario> query = em.createQuery("SELECT obj FROM Funcionario obj", Funcionario.class);
            List<Funcionario> Funcionarios = query.getResultList();
            return Funcionarios;
        } catch (RuntimeException e) {
        	System.out.println("Falha ao listar no método buscarTodos na classe FuncionarioDAO" + e.getMessage());
            return null;
        }
    }

}
