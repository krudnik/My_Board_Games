package pl.coderslab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.coderslab.game.GameConverter;
import pl.coderslab.play.PlayConverter;
import pl.coderslab.user.UserConverter;

import javax.persistence.EntityManagerFactory;
import javax.xml.validation.Validator;
import java.util.Locale;

@Configuration
@ComponentScan(basePackages = "pl.coderslab")
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.coderslab")
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean entityManagerFactoryBean
                = new LocalEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("bookstorePersistenceUnit");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }


    @Bean(name = "localeResolver")
    public LocaleContextResolver getLocaleContextResolver() {
        FixedLocaleResolver localeResolver = new FixedLocaleResolver(new Locale("pl", "PL"));
        return localeResolver;

    }

    @Bean
    public GameConverter gameConverter() {
        return new GameConverter();
    }

    @Bean
    public UserConverter userConverter() {
        return new UserConverter();
    }

    @Bean
    public PlayConverter playConverter() {
        return new PlayConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(gameConverter());
        registry.addConverter(userConverter());
        registry.addConverter(playConverter());

    }
}
