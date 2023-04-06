package com.linkknown.eden;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhoupeng
 */
@SpringBootApplication
@ComponentScan("com.linkknown.eden")
@MapperScan(basePackages = {"com.linkknown.eden.mapper"})
@EnableScheduling
public class EdenWebApplication {

    private static Logger logger = LoggerFactory.getLogger(EdenWebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EdenWebApplication.class, args);
        logger.info("========== eden_web 服务启动完成 ==========");
    }

}
