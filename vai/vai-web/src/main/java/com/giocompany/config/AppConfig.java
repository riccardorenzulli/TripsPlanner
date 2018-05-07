package com.giocompany.config;

import com.giocompany.entities.User;
import com.giocompany.facades.AbstractFacade;
import com.giocompany.facades.RegistrationFacade;
import com.giocompany.facades.UserFacade;
import com.giocompany.managers.RegistrationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.giocompany.web.*","com.giocompany.managers.*", "com.giocompany.facades", "com.giocompany.entities"})
@Import({ SecurityConfig.class , RegistrationManager.class, RegistrationFacade.class, UserFacade.class, User.class})
public class AppConfig {

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    driverManagerDataSource.setUrl("jdbc:mysql://giobindb.ch2bmmevu4iw.eu-west-2.rds.amazonaws.com:3306/MySQL_db");
	    driverManagerDataSource.setUsername("admin");
	    driverManagerDataSource.setPassword("adminadmin");
	    return driverManagerDataSource;
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
        
//        @Bean
//        public LocalStatelessSessionProxyFactoryBean proxyejb() {
//            LocalStatelessSessionProxyFactoryBean local = new LocalStatelessSessionProxyFactoryBean();
//            local.setJndiName("RegistrationManager");
//            local.setBusinessInterface(com.giocompany.managers.RegistrationManagerLocal.class);
//            return local;
//        }
	
}