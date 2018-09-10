package org.spring.springboot.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = PostgresqlDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "postgresqlSqlSessionFactory")
public class PostgresqlDataSourceConfig {

    // 精确到 postgresql 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.spring.springboot.dao.postgresql";
    static final String MAPPER_LOCATION = "classpath:mapper/postgresql/*.xml";

    @Value("${postgresql.datasource.url}")
    private String url;

    @Value("${postgresql.datasource.username}")
    private String user;

    @Value("${postgresql.datasource.password}")
    private String password;

    @Value("${postgresql.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "postgresqlDataSource")
    public DataSource postgresqlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "postgresqlTransactionManager")
    public DataSourceTransactionManager postgresqlTransactionManager() {
        return new DataSourceTransactionManager(postgresqlDataSource());
    }

    @Bean(name = "postgresqlSqlSessionFactory")
    public SqlSessionFactory postgresqlSqlSessionFactory(@Qualifier("postgresqlDataSource") DataSource postgresqlDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(postgresqlDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(PostgresqlDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}