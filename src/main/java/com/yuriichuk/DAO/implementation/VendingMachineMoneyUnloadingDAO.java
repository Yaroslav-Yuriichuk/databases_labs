package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineMoneyUnloading;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineMoneyUnloadingDAO implements AbsDAO<VendingMachineMoneyUnloading> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<VendingMachineMoneyUnloading> findAll() throws SQLException {
        List<VendingMachineMoneyUnloading> vendingMachineMoneyUnloadings
                = new ArrayList<VendingMachineMoneyUnloading>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineMoneyUnloadings = session.createQuery("from VendingMachineMoneyUnloading ")
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineMoneyUnloadings;
    }

    @Override
    public VendingMachineMoneyUnloading findById(Integer id) throws SQLException {
        VendingMachineMoneyUnloading vendingMachineMoneyUnloading = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineMoneyUnloading = session.get(VendingMachineMoneyUnloading.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineMoneyUnloading;
    }

    @Override
    public void create(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(vendingMachineMoneyUnloading);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(VendingMachineMoneyUnloading vendingMachineMoneyUnloading) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(vendingMachineMoneyUnloading);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            VendingMachineMoneyUnloading vendingMachineMoneyUnloading
                    = session.get(VendingMachineMoneyUnloading.class, id);
            if (vendingMachineMoneyUnloading != null) {
                session.delete(vendingMachineMoneyUnloading);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
