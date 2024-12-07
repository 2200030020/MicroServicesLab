package klu;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("klu")
@EnableWebMvc  //->to enable mvc
public class SpringConfig implements WebMvcConfigurer{
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry res) {
		
		res.jsp("/" , ".jsp");
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry reg) {
		reg.addResourceHandler("/**").addResourceLocations("/");
	}
	
	//configuration of mysql
	@Bean //depencey injection we can use set or by constructor
	public DataSource dataSource() { //set method
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jfsd_s17");
		ds.setUsername("root");
		ds.setPassword("@Ranganadh123#");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbctemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
