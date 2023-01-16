package pers;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ������,�̶�д��
 */

@SpringBootApplication
@MapperScan("pers.dao")  //��MyBatisɨ��Dao��λ��,��ÿ��Dao���ɽӿ�ʵ����
public class SpringBootStart {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStart.class, args);
    }
}
