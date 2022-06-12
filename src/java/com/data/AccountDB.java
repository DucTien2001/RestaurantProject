package com.data;

import com.business.Account;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AccountDB {
    public static void insert(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(account);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Account account) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(account));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    public static Account selectAccount(Integer id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                "WHERE a.id = :id";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("id", id);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static Account selectAccountByUser(String user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a WHERE a.user = :user " +
                "WHERE a.user = :user";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("user", user);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static List<Account> selectAccounts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
            Query qString = em.createQuery("SELECT a FROM Account a",Account.class);

            List<Account> Accounts = qString.getResultList();
            return Accounts;
        }finally
        {
            em.close();
        }
        
    }
    
    public static Account selectAccountUser(String user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                "WHERE a.user = :user";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("user", user);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    public static Account selectAccountUserPass(String user, String pass) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Account a " +
                "WHERE a.user = :user and a.pass = :pass";
        TypedQuery<Account> q = em.createQuery(qString, Account.class);
        q.setParameter("user", user);
        q.setParameter("pass", pass);
        try {
            Account account = q.getSingleResult();
            return account;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean accountIDExists(Integer id) {
        Account acc = selectAccount(id);   
        return acc != null;
    }
    
    public static boolean accountUserExists(String user) {
        Account acc = selectAccountUser(user);   
        return acc != null;
    }
    
    
 
    /*
    public static List<Menu> selectMenus() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try{
        Query qString = em.createQuery("SELECT m FROM Menu m",Menu.class);
       // TypedQuery<Menu> q = em.createQuery(qString, Menu.class);

        List<Menu> Menus = qString.getResultList();
//        try {
//            Menus = q.getResultList();
//            if (Menus == null || Menus.isEmpty())
//                Menus = null;
//        } finally {
//            em.close();
//        }
        return Menus;
        }finally
        {
            em.close();
        }
        
    }
*/

    public static List<Account> selectMenus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
