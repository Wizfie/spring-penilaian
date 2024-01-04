package example.penilaian;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("https://penilaian-logistic.vercel.app/")
                .allowedOrigins("https://penilaian-ms.vercel.app/")
                .allowedOrigins("http://localhost:5173")
                .allowedOrigins("http://192.168.43.176:5173/")
                .allowedOrigins("http://192.168.1.11:5173/")
                .allowedOrigins("http://192.168.1.5:5173/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Content-Type", "Authorization");
    }
}
