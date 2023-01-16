package pers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类,固定写法
 */

@SpringBootApplication
@MapperScan("pers.dao")  //给MyBatis扫描Dao的位置,给每个Dao生成接口实现类
public class SpringBootStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
    }
}
