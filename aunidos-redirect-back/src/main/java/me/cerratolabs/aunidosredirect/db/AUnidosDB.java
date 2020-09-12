package me.cerratolabs.aunidosredirect.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

public class AUnidosDB {
    private Environment env;
    private DataSource dataSource;

    public AUnidosDB() {
        this.dataSource = DataSourceBuilder.create()
            .driverClassName(env.getProperty("spring.datasource.driverClassName"))
            .url(env.getProperty("spring.datasource.url"))
            .username(env.getProperty("spring.datasource.username"))
            .password(env.getProperty("spring.datasource.password")).build();
    }
}