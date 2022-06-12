package com.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.business.Booktable;
import com.mysql.cj.conf.PropertyKey;

public class BookDB {

    public static void insert(Booktable booktable) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(booktable);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Booktable booktable) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(booktable);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Booktable booktable) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(booktable));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static Booktable selectTable(String idTable) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT b FROM Booktable b " +
                "WHERE b.idTable = :idTable";
        TypedQuery<Booktable> q = em.createQuery(qString, Booktable.class);
        q.setParameter("idTable", idTable);
        try {
            Booktable booktable = q.getSingleResult();
            return booktable;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean tableExists(String idTable) {
        Booktable b = selectTable(idTable);   
        return b!= null;
    }
}
