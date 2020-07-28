package com.example.demo.util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.example.demo.mapper")
@Configuration
public class MybatisConfig {
	

}
