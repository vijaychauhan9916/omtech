package com.consMang.common.util;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class HibernateSession {

	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

   private static	HibernateSession hibernateSession;

	
	/**
	 * Returns the ThreadLocal Session instance. Lazy initialize the
	 * <code>SessionFactory</code> if needed.
	 * 
	 * @return Session
	 * @throws HibernateException
	 */
	public static  Session getSession(SessionFactory sessionFactory) throws HibernateException {
		
	if(hibernateSession==null){
		hibernateSession=new HibernateSession();
	}
		
		Session session = threadLocal.get();

		if (session == null || !session.isOpen()) {
			session=	sessionFactory.openSession();
			threadLocal.set(session);
		}

		return session;
	}

	

	/**
	 * Close the single hibernate session instance.
	 * 
	 * @throws HibernateException
	 */
	public static  void closeSession() throws HibernateException {
		Session session = threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			session.close();
			
		}
	}

}
