/**
 * 
 */
package cz.darujdetem.web.test_conf;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;

/**
 * @author martin
 *
 */
public class JndiPostgresDataSourceInitilizer extends SimpleNamingContextBuilder implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public static final String DEFAULT_PREFIX = "java:comp/env/";
	
	public static final String DB_USER = "daruj";
	public static final String DB_PASSWORD = "Dar4uj";
	public static final String DB_DRIVER = "org.postgresql.Driver";
	
//	public JndiDataSourceInitilizer() {
//		super();
//	}
//
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUrl("jdbc:postgresql://localhost:5432/daruj");
		dataSource.setUsername(DB_USER);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setInitialSize(30);
		dataSource.setMinIdle(10);
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setValidationQueryTimeout(1);
		return dataSource;
	}

	@Override
	public void initialize(ConfigurableApplicationContext context) {
		bind(DEFAULT_PREFIX + "jdbc/daruj", dataSource());
		try {
			activate();
		} catch (IllegalStateException | NamingException e) {
			throw new IllegalStateException("Cannot initialize JNDI", e);
		}
	}
	
}
