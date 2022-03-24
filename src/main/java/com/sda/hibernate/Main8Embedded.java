package com.sda.hibernate;

import com.sda.hibernate.entity.Address;
import com.sda.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class Main8Embedded {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Address address = new Address("Ostrow","Nowa");
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2012");
        Employee employee = new Employee("Benio","dhcp",
                "987654365",34,date, Employee.Gender.MALE,"desepto");

        System.out.println("session = " + session);

        employee.setAddress(address);
        System.out.println("session = " + session);

        session.persist(employee);
        session.evict(employee);
        employee.setGender(Employee.Gender.FEMALE);
        System.out.println("session = " + session);

        transaction.commit();
        session.close();
        System.out.println("session = " + session);
    }
}
