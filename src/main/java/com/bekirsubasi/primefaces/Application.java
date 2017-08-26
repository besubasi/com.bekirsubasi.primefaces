package com.bekirsubasi.primefaces;

import javax.faces.webapp.FacesServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Alex on 28/02/2015.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"com.bekirsubasi.primefaces"})
public class Application extends SpringBootServletInitializer {
	

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
        return servletRegistrationBean;
    }
    
    /*@Bean
    public FilterRegistrationBean rewriteFilter() {
        FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
        rwFilter.setDispatcherTypes(EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST,
                DispatcherType.ASYNC, DispatcherType.ERROR));
        rwFilter.addUrlPatterns("/*");
        return rwFilter;
    }
    /*
    
    @Bean
    public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
    	Resource sourceData;
    	Jackson2RepositoryPopulatorFactoryBean factory;
		try {
			sourceData = new PathResource(init);
			if(!sourceData.exists())
				sourceData = new ClassPathResource(init);
			factory = new Jackson2RepositoryPopulatorFactoryBean();
			factory.setResources(new Resource[] { sourceData });
		} catch (Exception e) {
			return null;
		}

		return factory;
    }*/

}
