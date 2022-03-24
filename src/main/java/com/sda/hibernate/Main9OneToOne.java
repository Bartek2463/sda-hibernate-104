package com.sda.hibernate;

import com.sda.hibernate.entity.Husband;
import com.sda.hibernate.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.util.Optional;

public class Main9OneToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       Husband husband = session.find(Husband.class, 4L);
        Optional.ofNullable(husband);
        System.out.println(husband.getName());


        transaction.commit();
        session.close();
    }
}
