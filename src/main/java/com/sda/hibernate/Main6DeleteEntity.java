package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;

public class Main6DeleteEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dogOne = session.find(Dog.class, 3L);
        if (dogOne != null) {
            session.delete(dogOne);
        }

        try {
            Dog dogTwo = new Dog();
            dogTwo.setId(4L);
            session.delete(dogTwo);
            transaction.commit();
        } catch (OptimisticLockException e) {
            System.out.println("Krotka o podanym id nie istnieje w bazie: " + 4L);
        }

        session.close();
    }
}
