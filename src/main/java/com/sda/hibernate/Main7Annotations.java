package com.sda.hibernate;

import com.sda.hibernate.entity.Address;
import com.sda.hibernate.entity.Dog;
import com.sda.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

public class Main7Annotations {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Employee employee = new Employee();
        employee.setId(6L);
        employee.setGender(Employee.Gender.FEMALE);
        employee.setName("Kaka");
        employee.setSecret("blisko");
        System.out.println("session = " + session);

        employee.setDescription("kolejne");
        session.persist(employee);

        System.out.println("session = " + session);


        transaction.commit();
        session.close();
        System.out.println("session = " + session);
    }
}
