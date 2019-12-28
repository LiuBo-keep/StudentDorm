package com.hp.studentsushe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@MapperScan("com.hp.studentsushe.dao")
@ImportResource(locations = "classpath:mybatis/applicationContext.xml")
@SpringBootApplication
public class StudentsusheApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsusheApplication.class, args);
    }

}
