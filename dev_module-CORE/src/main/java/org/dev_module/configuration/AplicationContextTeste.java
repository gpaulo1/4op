package org.dev_module.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "org.dev_module.repository" })
@ComponentScan(basePackages = { "org.dev_module.service",
		"org.dev_module.service.impl", "org.dev_module.repository", "org.dev_module.query" })
@PropertySource("classpath:application-test.properties")
public class AplicationContextTeste {

	private static final Logger log = Logger
			.getLogger(ApplicationContext.class);

	@Resource
	private Environment em;

	@Bean
	public DataSource dataSource() {
		log.info("Inicializando DataSource teste");
		BoneCPDataSource ds = new BoneCPDataSource();
		ds.setDriverClass(em.getRequiredProperty("db.driver"));
		ds.setJdbcUrl(em.getRequiredProperty("db.url"));
		ds.setUsername(em.getRequiredProperty("db.username"));
		ds.setPassword(em.getRequiredProperty("db.password"));
		return ds;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		log.info("Inicializando Entity Manager teste");

		LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
		local.setDataSource(dataSource());
		local.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		local.setPackagesToScan(em
				.getRequiredProperty("entitymanager.packages.to.scan"));

		Properties prop = new Properties();

		prop.put("hibernate.dialect",
				em.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.format_sql",
				em.getRequiredProperty("hibernate.format_sql"));
		prop.put("hibernate.hbm2ddl.auto",
				em.getRequiredProperty("hibernate.hbm2ddl.auto"));
		prop.put("hibernate.ejb.naming_strategy",
				em.getRequiredProperty("hibernate.ejb.naming_strategy"));
		prop.put("hibernate.show_sql",
				em.getRequiredProperty("hibernate.show_sql"));

		local.setJpaProperties(prop);
		return local;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		return transactionManager;
	}

}
