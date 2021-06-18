package com.thyxsl.module;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;

/**
 * @author ：thyxsl
 * @date ：Created in 2021/6/17 22:43
 * @description：module
 * @modified By：
 * @version: 1.0$
 */
public class BasicModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    public DSLContext createDslContext() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.88.10/test?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        DataSourceConnectionProvider provider = new DataSourceConnectionProvider(dataSource);
        Configuration config = new DefaultConfiguration();
        config.set(provider);
        config.set(SQLDialect.MYSQL);
        return DSL.using(config);
    }
}
