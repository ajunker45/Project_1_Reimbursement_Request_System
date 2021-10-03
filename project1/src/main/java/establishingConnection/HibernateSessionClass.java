package establishingConnection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionClass {
	
	
	// this is gonna create a singleton factory. 
	
	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			Properties props = new Properties();
			//FileReader connectionProperties = null;
//			try {
//				FileReader connectionProperties;
//				connectionProperties = new FileReader("src/main/resources/connection.properties");
//				props.load(connectionProperties);
//				
//			} catch (IOException e ) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
			
			
			try {
				FileReader connectionProperties;
				connectionProperties = new FileReader("src/main/resources/connection.properties");
				props.load(connectionProperties);
				
				sessionFactory = new Configuration().configure()
						.setProperty("hibernate.connection.url", "jdbc:mariadb://" + props.getProperty("endpoint") + ":" + props.getProperty("port") + "/" + props.getProperty("dbname"))
						.setProperty("hibernate.connection.username",props.getProperty("username"))
						.setProperty("hibernate.connection.password",props.getProperty("password"))
						.buildSessionFactory();
			} catch (HibernateException | IOException e) {
				e.printStackTrace();
			}
			
		}
		return sessionFactory.getCurrentSession();
	}
	
}
