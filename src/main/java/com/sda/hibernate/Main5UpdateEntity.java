package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.Optional;

public class Main5UpdateEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = session.find(Dog.class, 18L);
        dog.setId(18L);
        dog.setAge(3);
        dog.setName("Benio");
        dog.setRace("Jamnik");




        transaction.commit();
        session.close();

    }
}
