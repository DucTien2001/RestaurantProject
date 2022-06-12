package com.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.business.Menu;
import java.util.List;
import javax.persistence.Query;

public class MenuDB {

    public static void insert(Menu menu) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(menu);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Menu menu) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(menu);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Menu menu) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(menu));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Menu selectMenuId(int menuId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT m FROM Menu m "
                + "WHERE m.menuId = :menuId";
        TypedQuery<Menu> q = em.createQuery(qString, Menu.class);
        q.setParameter("menuId", menuId);
        try {
            Menu menu = q.getSingleResult();
            return menu;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static Menu selectMenu(int menuId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT m FROM Menu m "
                + "WHERE m.menuId = :menuId";
        TypedQuery<Menu> q = em.createQuery(qString, Menu.class);
        q.setParameter("menuId", menuId);
        //int mId = Integer.parseInt(menuId);
        //q.setParameter("mId", mId);
        try {
            Menu menu = q.getSingleResult();
            return menu;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean menuIDExists(int menuId) {
        Menu m = selectMenu(menuId);
        return m != null;
    }

    public static List<Menu> selectMenus() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Query qString = em.createQuery("SELECT m FROM Menu m", Menu.class);
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
        } finally {
            em.close();
        }

    }
//    public byte[] loadImage(int menuId){
//        EntityManager em = DBUtil.getEmFactory().createEntityManager();
//        return em.find(Menu.class, menuId).getPicture();
//    }

    public static void main(String[] args) {

        //MenuDB m = new MenuDB();
        //Menu item = m.selectMenu("1");
        //System.out.println(item);
        //List<Menu> list = m.selectMenus();
        //System.out.println(list);
        List<Menu> menus = MenuDB.selectMenus();
        System.out.println(menus);
    }
}
