package truong2k4.identityService.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Áp dụng cho tất cả các endpoint
                        .allowedOrigins("http://localhost:3000") // Cho phép từ domain cụ thể
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Các method được phép
                        .allowedHeaders("*") // Chấp nhận tất cả các header
                        .allowCredentials(true); // Cho phép cookie
            }
        };
    }
}
