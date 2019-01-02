package com.consMang.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

import com.consMang.interceptor.AdminInterceptor;
import com.consMang.interceptor.SessionInterceptor;

@Configuration
@ComponentScan("com.consMang.*")
@EnableWebMvc
public class AppWebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] {
				"WEB-INF/tiles/homePageTiles.xml",
				"WEB-INF/tiles/adminPageTiles.xml"
				
		});


		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	TilesViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxInMemorySize(500*1024*1024);
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/**");
		 registry.addInterceptor(getAdminInterceptor()).addPathPatterns("/admin/**");
		 
	}
	
	@Bean
	public SessionInterceptor getSessionInterceptor() {
	    return new SessionInterceptor();
	}
	@Bean
	public AdminInterceptor getAdminInterceptor() {
	    return new AdminInterceptor();
	}
}
