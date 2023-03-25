package edu.web.yjt_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.web.yjt_backend.mapper")
public class YjtBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(YjtBackEndApplication.class, args);
    }

}
