package com.sda.hibernate;

import com.sda.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main7Annotations {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");
        Employee employee = new Employee("Jan", "strongPassword", "123456789", 20, date,
                Employee.Gender.MALE, "description");

        session.persist(employee);

        transaction.commit();
        session.close();
    }
}
