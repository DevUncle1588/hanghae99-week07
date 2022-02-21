package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedHeaders("*"); // preflight request가 사용할 수 있게 허용하는 헤더목록.
//                .exposedHeaders("Authorization") //response가 단순 header 이외에 가능한 헤더 목록.
//                .allowCredentials(true); //브라우저가 쿠키와 같은 자격 증명을 크로스 도메인 요청시에 보내게 한다. Access-Control-Allow-Credentials 응답 헤더에 설정됩니다.
    }
}
