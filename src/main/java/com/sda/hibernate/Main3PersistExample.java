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

        Dog dog = new Dog("Azor", 10, "Husky");
        System.out.println("Id: " + dog.getId());
        session.persist(dog); // insert into dog (age, name, race) values (?, ?, ?)
        System.out.println("Id: " + dog.getId());

        dog.setAge(11);
        // session.evict(dog);
        dog.setRace("Chihuahua");

        transaction.commit(); // update dog set age=?, name=?, race=? where id=?
        session.close();
    }
}
