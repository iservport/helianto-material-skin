package org.helianto.root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableOAuth2Sso
@EnableResourceServer
@EnableWebSecurity
public abstract class RootApplication extends WebMvcConfigurerAdapter {

    @Configuration
    static class ResourceServer extends ResourceServerConfigurerAdapter {

        @Autowired
        private OAuth2ClientContextFilter oauth2ClientContextFilter;

        @Autowired(required = false)
        private HeliantoResourceServerConfigurer heliantoResourceServerConfigurer;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http
                    .requestMatchers().antMatchers("/api/**")
                    .and().servletApi()
//                    .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and().authorizeRequests().anyRequest().access("#oauth2.hasScope('write')")
                    .and()
                    .addFilterAfter(oauth2ClientContextFilter, SecurityContextPersistenceFilter.class)
                    .csrf().disable()
                    ;
            // @formatter:on
            if (heliantoResourceServerConfigurer!=null) {
                heliantoResourceServerConfigurer.configure(http);
            }
        }

    }

    @Configuration
    public class RootWebSecurityConfig extends WebSecurityConfigurerAdapter {

        public void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/").authorizeRequests().anyRequest().permitAll()
                .and().logout()
                    .deleteCookies("JSESSIONID")
                    .deleteCookies("remember-me")
                    .deleteCookies("X-XSRF-TOKEN")
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login");
        }

    }

    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oauth2ClientContext);
    }

    @Bean
    public HomeController homeController() { return new HomeController(); }

    @Bean
    public AppController appController(OAuth2RestOperations restTemplate) { return new AppController(restTemplate); }

    @Bean
    public TemplatesController templatesController() { return new TemplatesController(); }

    @Bean
    public Docket rootApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .pathMapping("/")
                ;
    }

}
