package com.kpi.db.configuration;

import org.jooq.DSLContext;
import org.jooq.impl.*;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

import static com.kpi.db.domain.City.*;
import static java.util.Collections.unmodifiableMap;
import static org.jooq.SQLDialect.POSTGRES_9_4;

import java.util.HashMap;
import java.util.Map;

import com.kpi.db.domain.City;

@Configuration
public class DbConfiguration {

    @Bean
    public Map<City, DSLContext> dslContextMap() {
        Map<City, DSLContext> dataSourceMap = new HashMap<City, DSLContext>() {{
            put(KYIV, kyivDsl());
            put(LVIV, lvivDsl());
            put(KHARKIV, kharkivDsl());
        }};
        return unmodifiableMap(dataSourceMap);
    }

    @Bean
    DefaultDSLContext kyivDsl() {
        DataSourceConnectionProvider connectionProvider = connectionProvider(kyivDataSource());
        DefaultConfiguration configuration = configuration(connectionProvider);
        return new DefaultDSLContext(configuration);
    }

    @Bean
    DefaultDSLContext lvivDsl() {
        DataSourceConnectionProvider connectionProvider = connectionProvider(lvivDataSource());
        DefaultConfiguration configuration = configuration(connectionProvider);
        return new DefaultDSLContext(configuration);
    }

    @Bean
    DefaultDSLContext kharkivDsl() {
        DataSourceConnectionProvider connectionProvider = connectionProvider(kharkivDataSource());
        DefaultConfiguration configuration = configuration(connectionProvider);
        return new DefaultDSLContext(configuration);
    }

    private DefaultConfiguration configuration(DataSourceConnectionProvider connectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider);
        jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
        jooqConfiguration.set(POSTGRES_9_4);
        return jooqConfiguration;
    }

    private DataSourceConnectionProvider connectionProvider(DataSource dataSource) {
        TransactionAwareDataSourceProxy transactionAwareDataSource = new TransactionAwareDataSourceProxy(dataSource);
        return new DataSourceConnectionProvider(transactionAwareDataSource);
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    DataSource kyivDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.secondDatasource")
    DataSource lvivDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.thirdDatasource")
    DataSource kharkivDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    DefaultExecuteListener exceptionTransformer() {
        return new DefaultExecuteListener();
    }
}