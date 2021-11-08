package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO implements AbsDAO<Brand> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Brand> findAll() throws SQLException {
        List<Brand> brands = new ArrayList<Brand>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            brands = session.createQuery("from Brand ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return brands;
    }

    @Override
    public Brand findById(Integer id) throws SQLException {
        Brand brand = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            brand = session.get(Brand.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return brand;
    }

    @Override
    public void create(Brand brand) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(brand);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Brand brand) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(brand);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Brand brand = session.get(Brand.class, id);
            if (brand != null) {
                session.delete(brand);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
