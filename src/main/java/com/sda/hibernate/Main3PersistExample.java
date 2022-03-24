package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main3PersistExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("",4,"","wet");

        session.persist(dog);
        session.evict(dog);
        dog.setName("Azor");

        transaction.commit(); // update dog set age=?, name=?, race=? where id=?
        session.close();
    }
}
