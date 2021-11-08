package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.Address;
import com.yuriichuk.model.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements AbsDAO<Address> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Address> findAll() throws SQLException {
        List<Address> addresses = new ArrayList<Address>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            addresses = session.createQuery("from Address ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addresses;
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        Address address = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            address = session.get(Address.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public void create(Address address) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Address address) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Address address = session.get(Address.class, id);
            if (address != null) {
                session.delete(address);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
