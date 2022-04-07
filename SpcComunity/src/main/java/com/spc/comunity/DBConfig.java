package com.spc.comunity;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.spc.comunity.dao") // JPA ����� ���� ��Ű�� Ž��
@MapperScan("com.spc.comunity.dao") // MyBatis ����� ���� ��Ű�� Ž��
public class DBConfig {

	@Value("${spring.datasource.password}")
	String dbPassword;
	@Value("${spring.datasource.driver-class-name}")
	String dbClassName;
	@Value("${spring.datasource.url}")
	String dbUrl;
	@Value("${spring.datasource.username}")
	String dbUserName;

	// DB ����
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(dbClassName);
		datasource.setUrl(dbUrl);
		datasource.setUsername(dbUserName);
		datasource.setPassword(dbPassword);

		return datasource;
	}

	// jpa ����
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPersistenceUnitName("jpa-mysql"); // persistence.xml�� ���� ���ǵ� �̸�
		entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return entityManagerFactory;
	}

	// mybatis ����� ���� sessionFactory bean ���
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(
				new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")); // mybatis ��������
																										// ���
		return sqlSessionFactory;
	}

	// mybatis ����� ���� sqlSession bean ���
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlsessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlsessionFactory.getObject());
	}

	// transactional ����
	@Bean
	public PlatformTransactionManager transactionManager() throws Exception {
		// MyBatis transactional
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());

		// JPA transactional
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		// Chained transaction manager (MyBatis X JPA)
		ChainedTransactionManager transactionManager = new ChainedTransactionManager(jpaTransactionManager,
				dataSourceTransactionManager);
		return transactionManager;
	}
}