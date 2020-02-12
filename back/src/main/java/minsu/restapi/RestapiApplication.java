package minsu.restapi;

import minsu.restapi.persistence.property.FileUploadProperties;
import minsu.restapi.spring.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties({
        FileUploadProperties.class
})
public class RestapiApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

    @Autowired
    private JwtInterceptor jwtInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtInterceptor).addPathPatterns("/user/auth/**", "/todo/auth/**", "/subtitle/auth/**"
//                ,"/category1/auth/**", "/category2/auth/**", "/calendar/auth/**");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/todo/auth/**", "/subtitle/auth/**"
                ,"/category1/auth/**", "/category2/auth/**", "/calendar/auth/**");

        // 나중에 토큰 체크할 부분
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //.allowedMethods("GET", "POST", "OPTIONS", "PUT")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("token");
        //.exposedHeaders("Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
    }

}
