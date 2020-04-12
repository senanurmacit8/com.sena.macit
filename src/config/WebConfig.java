package src.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import src.main.interceptor.ControllerInterceptor;

//to do
//import tr.edu.duzce.mf.bm.springextjs.interceptor.ControllerInterceptor;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = {"src"})
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
            configurer.enable();
        }

        @Bean
        public InternalResourceViewResolver jspViewResolver() {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("/WEB-INF/view/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new ControllerInterceptor()).addPathPatterns("/*");
            registry.addInterceptor(localeInterceptor()).addPathPatterns("/*");
        }

        @Bean(name = "messageSource")
        public ReloadableResourceBundleMessageSource getMessageSource() {
            ReloadableResourceBundleMessageSource messageSource =
                    new ReloadableResourceBundleMessageSource();
            messageSource.setBasename("classpath:messages");
            messageSource.setDefaultEncoding("UTF-8");
            return messageSource;
        }

        @Bean
        public SessionLocaleResolver localeResolver(){
            SessionLocaleResolver localeResolver = new SessionLocaleResolver();
            localeResolver.setDefaultLocale(Locale.forLanguageTag("TR"));
            return localeResolver;
        }

        @Bean
        public LocaleChangeInterceptor localeInterceptor(){
            LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
            interceptor.setParamName("lang");
            return interceptor;
        }


        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
            stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text",
                    "plain", Charset.forName("UTF-8"))));
            converters.add(stringConverter);

            // varsa diger converter tanimlari ...
        }

}
