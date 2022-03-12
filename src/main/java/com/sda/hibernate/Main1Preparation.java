package com.sda.hibernate;

import org.hibernate.SessionFactory;

public class Main1Preparation {

    // MetadataSources metadataSources = new MetadataSources(registry);
    // Metadata metadata = metadataSources.buildMetadata();
    // SessionFactory sessionFactory = metadata.buildSessionFactory();

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    }
}
