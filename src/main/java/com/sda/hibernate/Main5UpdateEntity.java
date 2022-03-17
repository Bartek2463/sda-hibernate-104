package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class Main5UpdateEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

       Dog rite = session.find(Dog.class,10L);
       Optional.ofNullable(rite);
        System.out.println(rite);


        session.update(rite);
        rite.setId(10L);
        rite.setRace("Jamnik");
        rite.setName("Benio");
        rite.setAge(4);








        transaction.commit();
        session.close();
    }
}
