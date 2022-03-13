package com.sda.hibernate;

import com.sda.hibernate.entity.Address;
import com.sda.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main8Embedded {

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Address address = new Address("Gdansk", "Aleja Grunwaldzka");

        Date date = new SimpleDateFormat("dd/MM/yyyy")
                .parse("31/12/1998");
        Employee employee = new Employee("Ola", "strongPassword",
                "987654321", 20, date,
                Employee.Gender.FEMALE, "description");

        employee.setAddress(address);

        address.setStreet("Chopina");

        session.persist(employee);

        transaction.commit();
        session.close();
    }
}
