package dao;

import classes.Classificacao;
import util.JPAUtil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ClassificacaoDAO {

    private EntityManager em;

    public ClassificacaoDAO() {
    }

    public boolean salvar(Classificacao entity) {
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

    public boolean atualizar(Classificacao entity) {
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
            Classificacao entity = em.find(Classificacao.class, id);
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

    public Classificacao buscarID(int id) {
        try {
            em = JPAUtil.getEntityManager();
            Classificacao entity = em.find(Classificacao.class, id);
            return entity;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

    public Classificacao buscarIdQuarto(Long classificacao, Long quarto) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Classificacao> query = em.createQuery("SELECT q.classificacao\n" +
                    "FROM Quarto q\n" +
                    "WHERE q.classificacao.idClassificacao = :idClassificacao AND q.idQuarto = :idQuarto", Classificacao.class);
            query.setParameter("idClassificacao", classificacao);
            query.setParameter("idQuarto", quarto);
            return query.getSingleResult();
        }catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }


    public List<Classificacao> buscarPorAr(String cama) {
        try {
            em = JPAUtil.getEntityManager();
            TypedQuery<Classificacao> query = em.createQuery("SELECT obj FROM Classificacao obj WHERE obj.cama = :cama", Classificacao.class);
            query.setParameter("cama", cama);
            List<Classificacao> classificacoes = query.getResultList();
            return classificacoes;
        } catch (RuntimeException e) {
            //e.printStackTrace();
            return null;
        }
    }

}
