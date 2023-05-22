package com.leandro.hruser.config;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

@Configuration
public class DataInitializationConfig {

    private final DataSource dataSource;

    public DataInitializationConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void initData() {
        try {
            Connection connection = dataSource.getConnection();
            ScriptUtils.executeSqlScript(connection, (Resource) new BufferedReader(
                    new InputStreamReader(getInputStream("data.sql"), StandardCharsets.UTF_8)));
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private InputStream getInputStream(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
