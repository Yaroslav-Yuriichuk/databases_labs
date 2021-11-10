package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.Address;
import com.yuriichuk.model.Technician;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianDAO implements AbsDAO<Technician> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Technician> findAll() throws SQLException {
        List<Technician> technicians = new ArrayList<Technician>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            technicians = session.createQuery("from Technician ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return technicians;
    }

    @Override
    public Technician findById(Integer id) throws SQLException {
        Technician technician = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            technician = session.get(Technician.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return technician;
    }

    @Override
    public void create(Technician technician) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(technician);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Technician technician) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(technician);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Technician technician = session.get(Technician.class, id);
            if (technician != null) {
                session.delete(technician);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
