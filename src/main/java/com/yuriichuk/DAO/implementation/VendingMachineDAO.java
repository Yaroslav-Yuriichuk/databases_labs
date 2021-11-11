package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.Technician;
import com.yuriichuk.model.VendingMachine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDAO implements AbsDAO<VendingMachine> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<VendingMachine> findAll() throws SQLException {
        List<VendingMachine> vendingMachines = new ArrayList<VendingMachine>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachines = session.createQuery("from VendingMachine ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachines;
    }

    @Override
    public VendingMachine findById(Integer id) throws SQLException {
        VendingMachine vendingMachine = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachine = session.get(VendingMachine.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachine;
    }

    @Override
    public void create(VendingMachine vendingMachine) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(vendingMachine);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(VendingMachine vendingMachine) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(vendingMachine);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            VendingMachine vendingMachine = session.get(VendingMachine.class, id);
            if (vendingMachine != null) {
                session.delete(vendingMachine);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
