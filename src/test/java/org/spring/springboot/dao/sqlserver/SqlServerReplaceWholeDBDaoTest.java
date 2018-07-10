package org.spring.springboot.dao.sqlserver;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.dao.mysql.MysqlLinBanDao;
import org.spring.springboot.domain.LinBan;
import org.spring.springboot.domain.TableInfo;
import org.spring.springboot.util.PositionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/9 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SqlServerReplaceWholeDBDaoTest {
    private List<String> excludeTables = Arrays.asList("By", "flv", "GG", "KKK");
    private List<String> contentFieldTypes = Arrays.asList("varchar", "nvarchar");
    private String keyWord = "祁连山";
    private String replaceKeyWord = "兴隆山";
    @Autowired
    private SqlServerReplaceWholeDBDao sqlServerReplaceWholeDBDao; // 主数据源

    @Test
    public void queryAllTableName() throws Exception {
        List<String> list = sqlServerReplaceWholeDBDao.queryAllTableName();
        list.forEach(System.out::println);
    }
    @Test
    public void queryInfoByTableName() throws Exception {
        List<TableInfo> list = sqlServerReplaceWholeDBDao.queryInfoByTableName("巡护排班");
        list.forEach(System.out::println);
    }

    @Test
    public void queryField() throws Exception {
        List<String> list = sqlServerReplaceWholeDBDao.queryField("巡护排班", "备注", "%"+keyWord+"%");
        list.forEach(System.out::println);
    }

    @Test
    public void updateField() throws Exception {
        System.out.println(sqlServerReplaceWholeDBDao.updateField("巡护排班", "备注", "大王叫我来巡山咯祁连山", "大王叫我来巡山咯兴隆山"));
    }

    @Test
    public void transform() throws Exception{
        List<String> tableNameList = sqlServerReplaceWholeDBDao.queryAllTableName();

        for (int i = 0; i < tableNameList.size(); i++) {
            String tableName = tableNameList.get(i);
            List<TableInfo> tableInfoList = sqlServerReplaceWholeDBDao.queryInfoByTableName(tableName);
            for (int j = 0; j < tableInfoList.size(); j++) {
                String fieldType = tableInfoList.get(j).getData_type();
                if(contentFieldTypes.contains(fieldType)){

                }
            }
        }
    }
}