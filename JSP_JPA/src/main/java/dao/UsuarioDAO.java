package dao;

import classes.Usuario;
import util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO {

    private EntityManager em;

    public UsuarioDAO() {
    }

    public boolean salvar(Usuario entity) {
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
            System.out.println("Falha ao salvar no método salvar na classe UsuarioDAO" + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(Usuario entity) {
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
            System.out.println("Falha de atualização no método atualizar na classe UsuarioDAO" + e.getMessage());
            return false;
        }
    }

    public boolean remover(long id) {
        try {
            em = JPAUtil.getEntityManager();
            em.getTransaction().begin();
            Usuario entity = em.find(Usuario.class, id);
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Falha ao remover no método remover na classe UsuarioDAO" + e.getMessage());
            return false;
        }
    }

    public Usuario buscarID(Long idUsuario) {
        try {
            em = JPAUtil.getEntityManager();
            Usuario entity = em.find(Usuario.class, idUsuario);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Falha de busca no método buscarID na classe UsuarioDAO" + e.getMessage());
            return null;
        }
    }

    public List<Usuario> buscarTodos() {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Usuario> query = em.createQuery("SELECT obj FROM Usuario obj", Usuario.class);
            List<Usuario> Usuarios = query.getResultList();
            return Usuarios;
        } catch (RuntimeException e) {
        	System.out.println("Falha de listagem no método buscarTodos na classe UsuarioDAO" + e.getMessage());
            return null;
        }
    }
    
    public boolean login(String email, String senha) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Usuario> query = em.createQuery("SELECT obj FROM Usuario obj WHERE obj.email =:email AND obj.senha =:senha", Usuario.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            Usuario usuario = query.getSingleResult();
            return (usuario != null);
        } catch (RuntimeException e) {
        	System.out.println("Falha de login no método login na classe UsuarioDAO" + e.getMessage());
            return false;
        }
    }
    

}
