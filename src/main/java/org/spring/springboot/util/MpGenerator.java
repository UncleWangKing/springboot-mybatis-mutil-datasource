package org.spring.springboot.util;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MpGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig()
        .setOutputDir(System.getProperty("user.dir") + "/src/main/java/org/spring/springboot/util/")
        .setFileOverride(true)
        .setActiveRecord(true)// 不需要ActiveRecord特性的请改为false
        .setEnableCache(false)// XML 二级缓存
        .setBaseResultMap(true)// XML ResultMap
        .setBaseColumnList(false)// XML columList
        .setIdType(IdType.AUTO)
        .setServiceName("%sService")
        .setAuthor("gumh");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.POSTGRE_SQL);
        dsc.setDriverName("org.postgresql.Driver");
        dsc.setUsername("postgres");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:postgresql://localhost:5432/env");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig()
        .setCapitalMode(true)// 全局大写命名 ORACLE 注意
        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
        /**
         * 只需修改表名
         */
        .setInclude(new String[] { "sys_user" }); // 需要生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig()
        .setParent("")
        .setMapper("dao")
        .setService("service")
        .setController("controller")
        .setEntity("model")
        .setXml("dao");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}