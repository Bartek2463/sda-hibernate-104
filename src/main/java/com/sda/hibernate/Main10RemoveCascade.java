package com.sda.hibernate;

import com.sda.hibernate.entity.Husband;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main10RemoveCascade {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = session.find(Husband.class, 17L);
        if (husband != null) {
            session.remove(husband);
        }

        transaction.commit();
        session.close();
    }
}
