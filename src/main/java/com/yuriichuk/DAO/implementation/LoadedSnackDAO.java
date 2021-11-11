package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.Brand;
import com.yuriichuk.model.LoadedSnack;
import com.yuriichuk.model.LoadedSnackPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoadedSnackDAO implements AbsDAO<LoadedSnack> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<LoadedSnack> findAll() throws SQLException {
        List<LoadedSnack> loadedSnacks = new ArrayList<LoadedSnack>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            loadedSnacks = session.createQuery("from LoadedSnack ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loadedSnacks;
    }

    @Override
    public LoadedSnack findById(Integer firstId, Integer secondId) throws SQLException {
        LoadedSnack loadedSnack = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            loadedSnack = session.get(LoadedSnack.class, new LoadedSnackPK(firstId, secondId));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loadedSnack;
    }

    @Override
    public void create(LoadedSnack loadedSnack) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(loadedSnack);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(LoadedSnack loadedSnack) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(loadedSnack);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            LoadedSnack loadedSnack = session.get(LoadedSnack.class, new LoadedSnackPK(firstId, secondId));
            if (loadedSnack != null) {
                session.delete(loadedSnack);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
