package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.Snack;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnackDAO implements AbsDAO<Snack> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Snack> findAll() throws SQLException {
        List<Snack> snacks = new ArrayList<Snack>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            snacks = session.createQuery("from Snack ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return snacks;
    }

    @Override
    public Snack findById(Integer id) throws SQLException {
        Snack snack = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            snack = session.get(Snack.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return snack;
    }

    @Override
    public void create(Snack snack) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(snack);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Snack snack) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(snack);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Snack snack = session.get(Snack.class, id);
            if (snack != null) {
                session.delete(snack);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
