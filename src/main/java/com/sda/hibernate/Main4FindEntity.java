package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class Main4FindEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = session.find(Dog.class, 1L);
        if (dog != null) {

            System.out.println("dog.getId() = " + dog.getId());
            System.out.println("dog.getRace() = " + dog.getRace());

        }

        Dog dog1 = session.get(Dog.class, 4L);
        if (dog1 != null) {
            System.out.println("dog1.getId() = " + dog1.getId());
            System.out.println("dog1 = " + dog1.getRace());
        }


        Dog dog2 = session.load(Dog.class, 6L);

        if (dog2 != null) {
            System.out.println("dog2.getAge() = " + dog2.getAge());
            System.out.println("dog2.getId() = " + dog2.getId());
        }


        transaction.commit();
        session.close();
    }
}
