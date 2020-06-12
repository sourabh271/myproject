package net.project.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.project.dao.ContactDAOImpl;
import net.project.dao.ContactDao;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages="net.project")
public  class SpringMvcConfig implements WebMvcConfigurer{

@Bean
public DataSource getDataSource()
{


	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	//dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
	dataSource.setUsername("root");
	dataSource.setPassword("sourabh");
	
	return dataSource;
	
}


@Bean
public ViewResolver getViewResolver() {
	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/views/");
	resolver.setSuffix(".jsp");
	return resolver;
	
}

public ContactDao getContactDao() {
	
	return new ContactDAOImpl(getDataSource());
}


@Override
public void configurePathMatch(PathMatchConfigurer configurer) {
	// TODO Auto-generated method stub
	
}


@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	// TODO Auto-generated method stub
	
}


@Override
public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
	// TODO Auto-generated method stub
	
}


@Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	// TODO Auto-generated method stub
	
}


@Override
public void addFormatters(FormatterRegistry registry) {
	// TODO Auto-generated method stub
	
}


@Override
public void addInterceptors(InterceptorRegistry registry) {
	// TODO Auto-generated method stub
	
}


@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO Auto-generated method stub
	
}


@Override
public void addCorsMappings(CorsRegistry registry) {
	// TODO Auto-generated method stub
	
}


@Override
public void addViewControllers(ViewControllerRegistry registry) {
	// TODO Auto-generated method stub
	
}


@Override
public void configureViewResolvers(ViewResolverRegistry registry) {
	// TODO Auto-generated method stub
	
}


@Override
public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	// TODO Auto-generated method stub
	
}


@Override
public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
	// TODO Auto-generated method stub
	
}


@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	// TODO Auto-generated method stub
	
}


@Override
public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
	// TODO Auto-generated method stub
	
}


@Override
public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
	// TODO Auto-generated method stub
	
}


@Override
public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
	// TODO Auto-generated method stub
	
}


@Override
public Validator getValidator() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public MessageCodesResolver getMessageCodesResolver() {
	// TODO Auto-generated method stub
	return null;
}
}