package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.VendingMachine;
import com.yuriichuk.model.VendingMachineSoldSnack;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineSoldSnackDAO implements AbsDAO<VendingMachineSoldSnack> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<VendingMachineSoldSnack> findAll() throws SQLException {
        List<VendingMachineSoldSnack> vendingMachineSoldSnacks
                = new ArrayList<VendingMachineSoldSnack>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineSoldSnacks = session.createQuery("from VendingMachineSoldSnack ")
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineSoldSnacks;
    }

    @Override
    public VendingMachineSoldSnack findById(Integer id) throws SQLException {
        VendingMachineSoldSnack vendingMachineSoldSnack = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineSoldSnack = session.get(VendingMachineSoldSnack.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineSoldSnack;
    }

    @Override
    public void create(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(vendingMachineSoldSnack);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(VendingMachineSoldSnack vendingMachineSoldSnack) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(vendingMachineSoldSnack);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            VendingMachineSoldSnack vendingMachineSoldSnack
                    = session.get(VendingMachineSoldSnack.class, id);
            if (vendingMachineSoldSnack != null) {
                session.delete(vendingMachineSoldSnack);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
