package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.Optional;

public class Main6DeleteEntity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        try{
            Dog god = new Dog();
            god.setId(7L);
            session.delete(god);
            transaction.commit();

        }catch (OptimisticLockException e){
            System.out.println("Nie ma takiej krotki");
        }

        session.close();

    }
}
