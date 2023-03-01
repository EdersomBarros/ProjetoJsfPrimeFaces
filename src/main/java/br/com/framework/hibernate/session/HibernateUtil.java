package br.com.framework.hibernate.session;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.faces.bean.ApplicationScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.SessionFactoryImplementor;

import br.com.framework.implementacao.crud.VariavelConexaoUtil;

/**
 * Responsável por estabelecer uma conexão com hibernate
 * 
 * @author edersom barros
 *
 */
@ApplicationScoped
public class HibernateUtil implements Serializable {

	private static final long serialVersionUID = 5852765865242260870L;

	public static String JAVA_COM_ENV_JDBC_DATA_SOURCE = "java:/comp/env/jdbc/datasource";

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			return sessionFactory;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("Erro ao Criar conexão sessionFactory");
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getCurrentSession() {

		return getSessionFactory().getCurrentSession();
	}

	public static Session openSession() {
		if (sessionFactory == null) {
			buildSessionFactory();

		}
		return sessionFactory.openSession();
	}

	public static Connection getConnectionProvider() throws SQLException {

		return ((SessionFactoryImplementor) sessionFactory).getConnectionProvider().getConnection();
	}

	public static Connection getConnection() throws Exception {

		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup(JAVA_COM_ENV_JDBC_DATA_SOURCE);

		return ds.getConnection();

	}
	
	public DataSource getDataSourceJndi() throws NamingException{
		
		InitialContext context = new InitialContext();
		return (DataSource) context.lookup(VariavelConexaoUtil.JAVA_COM_ENV_JDBC_DATA_SOURCE);
		
		
		
	}

}
