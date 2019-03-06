package com.jc;

<<<<<<< HEAD
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
>>>>>>> f14518782b323302b1d53949ddebc6805e31f635
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/4 14:46
 * @description：后台启动类
 * @modified By：
 * @version: $version$
 */
<<<<<<< HEAD
@SpringBootApplication
@MapperScan("com.jc.mapper")
=======
@SpringBootConfiguration
@EnableAutoConfiguration
>>>>>>> f14518782b323302b1d53949ddebc6805e31f635
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
