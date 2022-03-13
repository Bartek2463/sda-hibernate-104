package com.sda.hibernate;

import com.sda.hibernate.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dogOne = new Dog();        // id = null, name = null, age = null, race = null
        dogOne.setId(1L);              // id = 1, name = null, age = null, race = null
        dogOne.setName("Ares");        // id = 1, name = Ares, age = null, race = null
        dogOne.setAge(15);             // id = 1, name = Ares, age = 15, race = null
        session.update(dogOne);        // update dog set age=15, name='Ares', race=null where id=1

        System.out.println("----");

        Dog dogTwo = session.find(Dog.class, 2L); // select
        dogTwo.setAge(2);

        transaction.commit(); // update, update
        session.close();
    }
}
