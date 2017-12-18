package com.yy.dream.core.config.mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijingen on 2017/5/12.
 */
@Configuration
@MapperScan(value = "com.yy.dream.core.db.gen.mapper2", sqlSessionFactoryRef = "sqlSessionFactory1")
public class DaoConfig {

    @Value("${jdbc.dream.driverClass}")
    private String driverClass;
    @Value("${jdbc.dream.username}")
    private String username;
    @Value("${jdbc.dream.password}")
    private String password;

    @Value("${jdbc.dream1.jdbcUrl}")
    private String dream1JdbcUrl;
    @Value("${jdbc.dream0.jdbcUrl}")
    private String dream0JdbcUrl;


    @Primary
    @Bean
    public ComboPooledDataSource dataSource0() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl(dream0JdbcUrl);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        return comboPooledDataSource;
    }
    @Bean
    public ComboPooledDataSource dataSource1() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl(dream1JdbcUrl);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        return comboPooledDataSource;
    }
    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactory0() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource0());
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/yy/dream/core/db/sqlmap/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean
    public Map<Integer,SqlSessionFactory> sqlSessionFactoryMap() throws Exception {
        Map<Integer,SqlSessionFactory> sessionFactoryMap=new HashMap();
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource1());
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/yy/dream/core/db/sqlmap/*Mapper.xml"));
        sessionFactoryMap.put(0,sqlSessionFactory0());
        sessionFactoryMap.put(1,sqlSessionFactoryBean.getObject());
        return sessionFactoryMap;
    }

}
