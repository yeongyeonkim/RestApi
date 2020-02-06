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
        System.out.println("여기는오는데");
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/user/auth/**", "/todo/auth/**", "/subtitle/auth/**"
                                ,"/category1/auth/**", "/category2/auth/**", "/calendar/auth/**");
//                .excludePathPatterns(Arrays.asList("/**")).
//        .excludePathPatterns("/user", "/user/signin", "/user/signup");
        //  이런식으로 토큰이 필요 없는 부분 제외.a
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("token");
    }
}
