package net.com.dev_web.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "net.com.dev_web.controller",
		"org.dev_web.security" })
@Import(value = { org.dev_module.configuration.ApplicationContext.class })
public class ApplicationContext extends WebMvcConfigurerAdapter {

	private static final String DEFINICAO_TILES_PADRAO_GLOBAL = "/WEB-INF/web-tiles.xml";
	private static final String DEFINICAO_TILES_PADRAO_PAGE = "/WEB-INF/views/**/tiles-*.xml";
 
	private static final Logger logger = Logger
			.getLogger(ApplicationContext.class);

	@Override
	public void configureDefaultServletHandling(
			final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registy) {
		logger.info("Inicializando resources handlers");

		registy.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
		registy.addResourceHandler("/js/**").addResourceLocations(
				"/resources/js/");
		registy.addResourceHandler("/css/**").addResourceLocations(
				"/resources/css/");
		registy.addResourceHandler("/images/**").addResourceLocations(
				"/resources/images/");
		registy.addResourceHandler("/fonts/**").addResourceLocations(
				"/resources/fonts/");
		registy.addResourceHandler("/bootstrap/**").addResourceLocations(
				"/resources/bootstrap/");
	}

	@Bean
	public TilesViewResolver tileViewResolver() {
		logger.info("Inicializando Tiles ViewResolver...");
		return new TilesViewResolver();
	}

	@Bean
	public TilesConfigurer configuracaoTiles() {
		logger.info("Inicializando Tiles Configurer...");
		TilesConfigurer config = new TilesConfigurer();
		String[] definicoes = new String[2];
		definicoes[0] = DEFINICAO_TILES_PADRAO_GLOBAL;
		definicoes[1] = DEFINICAO_TILES_PADRAO_PAGE;
		config.setDefinitions(definicoes);
		return config;
	}

	@Bean
	public ObjectMapper objectMapper() {
		org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper();
		return objectMapper;
	}

	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		MappingJacksonJsonView mappingJacksonJsonView = new MappingJacksonJsonView();
		mappingJacksonJsonView.setContentType("application/json");
		mappingJacksonJsonView.setObjectMapper(this.objectMapper());
		mappingJacksonJsonView.setEncoding(JsonEncoding.UTF8);
		mappingJacksonJsonView.setPrefixJson(false);
		return mappingJacksonJsonView;
	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

		// Tiles
		viewResolvers.add(this.tileViewResolver());

		// Views
		List<View> defaultViews = new ArrayList<View>();

		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();

		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		contentNegotiatingViewResolver.setOrder(0);

		return contentNegotiatingViewResolver;
	}

}
