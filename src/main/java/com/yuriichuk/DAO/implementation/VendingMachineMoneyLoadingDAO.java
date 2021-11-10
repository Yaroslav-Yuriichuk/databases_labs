package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineMoneyLoadingDAO implements AbsDAO<VendingMachineMoneyLoading> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<VendingMachineMoneyLoading> findAll() throws SQLException {
        List<VendingMachineMoneyLoading> vendingMachineMoneyLoadings
                = new ArrayList<VendingMachineMoneyLoading>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineMoneyLoadings = session.createQuery("from VendingMachineMoneyLoading ")
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineMoneyLoadings;
    }

    @Override
    public VendingMachineMoneyLoading findById(Integer id) throws SQLException {
        VendingMachineMoneyLoading vendingMachineMoneyLoading = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineMoneyLoading = session.get(VendingMachineMoneyLoading.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineMoneyLoading;
    }

    @Override
    public void create(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(vendingMachineMoneyLoading);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(VendingMachineMoneyLoading vendingMachineMoneyLoading) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(vendingMachineMoneyLoading);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            VendingMachineMoneyLoading vendingMachineMoneyLoading
                    = session.get(VendingMachineMoneyLoading.class, id);
            if (vendingMachineMoneyLoading != null) {
                session.delete(vendingMachineMoneyLoading);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
