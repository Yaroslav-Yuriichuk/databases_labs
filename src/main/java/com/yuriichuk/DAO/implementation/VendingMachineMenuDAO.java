package com.yuriichuk.DAO.implementation;

import com.yuriichuk.DAO.AbsDAO;
import com.yuriichuk.HibernateUtil;
import com.yuriichuk.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineMenuDAO implements AbsDAO<VendingMachineMenu> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<VendingMachineMenu> findAll() throws SQLException {
        List<VendingMachineMenu> vendingMachineMenus = new ArrayList<VendingMachineMenu>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineMenus = session.createQuery("from VendingMachineMenu ").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineMenus;
    }

    @Override
    public VendingMachineMenu findById(Integer firstId, Integer secondId) throws SQLException {
        VendingMachineMenu vendingMachineMenu = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            vendingMachineMenu = session.get(VendingMachineMenu.class,
                    new VendingMachineMenuPK(firstId, secondId));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendingMachineMenu;
    }

    @Override
    public void create(VendingMachineMenu vendingMachineMenu) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(vendingMachineMenu);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(VendingMachineMenu vendingMachineMenu) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(vendingMachineMenu);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer firstId, Integer secondId) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            VendingMachineMenu vendingMachineMenu = session.get(VendingMachineMenu.class,
                    new VendingMachineMenuPK(firstId, secondId));
            if (vendingMachineMenu != null) {
                session.delete(vendingMachineMenu);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
