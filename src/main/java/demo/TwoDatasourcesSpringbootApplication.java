package demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TwoDatasourcesSpringbootApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(TwoDatasourcesSpringbootApplication.class, args);
    }
    
    @Bean(name = "primary")
    @Primary
    @ConfigurationProperties(prefix="datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondary")
    @ConfigurationProperties(prefix="datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "jdbcPrimary")
    @Autowired
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primary") DataSource dsPrimary) {
        return new JdbcTemplate(dsPrimary);
    }
    
    @Bean(name = "jdbcSecondary")
    @Autowired
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondary") DataSource dsSecondary) {
        return new JdbcTemplate(dsSecondary);
    }
    
}


