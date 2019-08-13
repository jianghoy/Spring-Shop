package testDao;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@ComponentScan("onlineShop.dao")
public class TestConfiguration {
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
   	 LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
   	 sessionFactory.setDataSource(dataSource());
   	 sessionFactory.setPackagesToScan("onlineShop.model");
   	 sessionFactory.setHibernateProperties(hibernateProperties());
   	 return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
   	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
   	 dataSource.setDriverClassName("org.h2.Driver");
   	 dataSource.setUrl("jdbc:h2:mem:myDb;DB_CLOSE_DELAY=-1");
   	 dataSource.setUsername("sa");
   	 dataSource.setPassword("");

   	 return dataSource;
    }

    @Bean
    public MultipartResolver multipartResolver() {
   	 CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
   	 multipartResolver.setMaxUploadSize(10240000);
   	 return multipartResolver;
    }

    private final Properties hibernateProperties() {
   	 Properties hibernateProperties = new Properties();
   	 hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
   	 hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
   	 return hibernateProperties;
    }

}
