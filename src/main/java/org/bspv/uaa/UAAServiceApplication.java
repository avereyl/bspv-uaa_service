package org.bspv.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UAAServiceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UAAServiceApplication.class, args);
    }

//    implements WebMvcConfigurer
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
//    }
//    
//    @Bean
//    FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {
//        FilterRegistrationBean<ForwardedHeaderFilter> filterRegBean = new FilterRegistrationBean<>();
//        filterRegBean.setFilter(new ForwardedHeaderFilter());
//        filterRegBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return filterRegBean;
//    }
    
    
}
