package by.ecp;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Vinty on 21.06.2017.
 */
@Configuration
@EnableCaching
@ComponentScan(basePackages = "by.ecp")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class TestConfig {
    @Value("${jdbc.url}")
    private String dbUrl;

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.show_sql}")
    private String showSql;

    @Value("${hibernate.format_sql}")
    private String formatSql;

    @Value("${hibernate.creation_policy}")
    private String creationPolicy;

    @Value("${hibernate.cache.use_second_level_cache}")
    private  String useSecondLevelCache;

    @Value("{hibernate.cache.use_query_cache}")
    private  String useQueryCache;

    @Value("{hibernate.cache.region.factory_class}")
    private String factoryClass;

    @Value("{net.sf.ehcache.configurationResourceName}")
    private String configurationResourceName;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("by.ecp");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.format_sql", formatSql);
        properties.setProperty("hibernate.hbm2ddl.auto", creationPolicy);

        properties.setProperty("hibernate.cache.use_second_level_cache", useSecondLevelCache);
        properties.setProperty("hibernate.cache.use_query_cache", useQueryCache);
        properties.setProperty("hibernate.cache.region.factory_class", factoryClass);
        properties.setProperty("net.sf.ehcache.configurationResourceName", configurationResourceName);

        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}
