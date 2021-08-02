package com.hbmtools.entities;
// Generated 17-May-2021, 8:02:32 AM by Hibernate Tools 5.4.7.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class BikeRental.
 * @see com.hbmtools.entities.BikeRental
 * @author Hibernate Tools
 */
public class BikeRentalHome {

	private static final Logger logger = Logger.getLogger(BikeRentalHome.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(BikeRental transientInstance) {
		logger.log(Level.INFO, "persisting BikeRental instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BikeRental instance) {
		logger.log(Level.INFO, "attaching dirty BikeRental instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(BikeRental instance) {
		logger.log(Level.INFO, "attaching clean BikeRental instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			logger.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(BikeRental persistentInstance) {
		logger.log(Level.INFO, "deleting BikeRental instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public BikeRental merge(BikeRental detachedInstance) {
		logger.log(Level.INFO, "merging BikeRental instance");
		try {
			BikeRental result = (BikeRental) sessionFactory.getCurrentSession().merge(detachedInstance);
			logger.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public BikeRental findById(java.lang.Integer id) {
		logger.log(Level.INFO, "getting BikeRental instance with id: " + id);
		try {
			BikeRental instance = (BikeRental) sessionFactory.getCurrentSession()
					.get("com.hbmtools.entities.BikeRental", id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(BikeRental instance) {
		logger.log(Level.INFO, "finding BikeRental instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.hbmtools.entities.BikeRental")
					.add(Example.create(instance)).list();
			logger.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
