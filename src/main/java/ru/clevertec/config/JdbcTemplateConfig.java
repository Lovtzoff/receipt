package ru.clevertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.clevertec.util.PropertiesUtils;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(PropertiesUtils.getYamlProperties().getDatasource().getDriver());
        dataSource.setUrl(PropertiesUtils.getYamlProperties().getDatasource().getUrl());
        dataSource.setUsername(PropertiesUtils.getYamlProperties().getDatasource().getUsername());
        dataSource.setPassword(PropertiesUtils.getYamlProperties().getDatasource().getPassword());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
