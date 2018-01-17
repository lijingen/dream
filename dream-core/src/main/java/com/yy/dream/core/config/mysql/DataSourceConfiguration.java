package com.yy.dream.core.config.mysql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static com.yy.dream.core.config.mysql.DataSourceType.DREAM0;
import static com.yy.dream.core.config.mysql.DataSourceType.DREAM1;


@Configuration
@MapperScan(value = "com.yy.dream.core.db.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.dream0-datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.dream1-datasource")
    public DataSource dram1Datasource() {
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        RoutingDataSource routingDataSource=new RoutingDataSource();
        Map<Object, Object> targetDataSources= new HashMap();
        targetDataSources.put(DREAM0,primaryDataSource());
        targetDataSources.put(DREAM1,dram1Datasource());
        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(primaryDataSource());
        sqlSessionFactoryBean.setDataSource(routingDataSource);
        routingDataSource.afterPropertiesSet();
        sqlSessionFactoryBean.setMapperLocations(getResources("classpath*:com/yy/dream/core/db/sqlmap/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    public Resource[] getResources(String path) throws Exception{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        return resolver.getResources(path);
    }
}
