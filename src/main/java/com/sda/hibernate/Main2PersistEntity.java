package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2PersistEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Dog("Ares", 10, "Terier"));
        session.persist(new Dog("Sonia", 5, "Buldog"));
        session.persist(new Dog("Reksio", 6, "Doberman"));
        session.persist(new Dog("Benio", 12, "Jamnik"));
        session.persist(new Dog("Aza", 4, "Wilczur"));
        
        transaction.commit();
        session.close();
    }
}
