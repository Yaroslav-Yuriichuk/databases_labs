package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.VendingMachineMoneyLoading;
import com.yuriichuk.model.VendingMachineSnacksLoading;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineSnacksLoadingDAO implements AbsDAO<VendingMachineSnacksLoading> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<VendingMachineSnacksLoading> findAll() throws SQLException {
        List<VendingMachineSnacksLoading> vendingMachineSnacksLoadings
                = new ArrayList<VendingMachineSnacksLoading>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineSnacksLoadings = session.createQuery("from VendingMachineSnacksLoading ")
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineSnacksLoadings;
    }

    @Override
    public VendingMachineSnacksLoading findById(Integer id) throws SQLException {
        VendingMachineSnacksLoading vendingMachineSnacksLoading = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineSnacksLoading = session.get(VendingMachineSnacksLoading.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineSnacksLoading;
    }

    @Override
    public void create(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(vendingMachineSnacksLoading);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(VendingMachineSnacksLoading vendingMachineSnacksLoading) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(vendingMachineSnacksLoading);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            VendingMachineSnacksLoading vendingMachineSnacksLoading
                    = session.get(VendingMachineSnacksLoading.class, id);
            if (vendingMachineSnacksLoading != null) {
                session.delete(vendingMachineSnacksLoading);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
