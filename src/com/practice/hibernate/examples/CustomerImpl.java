package com.practice.hibernate.examples;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerImpl implements ICustomer {

	private static Configuration configuration = null;
	@SuppressWarnings("unused")
	private static SessionFactory sessionFactory = null;

	static {
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();

	}

	@Override
	public void saveCustomer(final Customer customer) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = session.save(customer);
			transaction.commit();
			System.out.println("customer object persisted:" + id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			try {
				if (session != null) {
					session.close();
					System.out.println("Customer object from finally block: " + customer);
				}

			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void getCustomer(final int customerId) {

		Session session = null;
		try {

			session = sessionFactory.openSession();
			Customer customer = (Customer) session.load(Customer.class, customerId);
			System.out.println("The Customer object u r looking for:");
			System.out.println(customer);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateCustomer(final Customer customer) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(customer);
			transaction.commit();
			System.out.println("customer object is created.");

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			try {
				if (session != null) {
					session.close();
				}

			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void removeCustomer(final Customer customer) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(customer);
			transaction.commit();
			System.out.println("customer object is Removed.");

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			try {
				if (session != null) {
					session.close();
				}

			} catch (HibernateException e) {
				e.printStackTrace();
			}

		}

	}
}
