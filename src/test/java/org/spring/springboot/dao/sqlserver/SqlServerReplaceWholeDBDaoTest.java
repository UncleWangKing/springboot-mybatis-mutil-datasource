package org.spring.springboot.dao.sqlserver;

import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.domain.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/9 15:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Slf4j
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
        list.forEach(s->log.info(s));
    }
    @Test
    public void queryInfoByTableName() throws Exception {
        List<TableInfo> list = sqlServerReplaceWholeDBDao.queryInfoByTableName("sys_DeptInfo");
        list.forEach(System.out::println);
    }

    @Test
    public void queryField() throws Exception {
        List<String> list = sqlServerReplaceWholeDBDao.queryField("MainMenuConfig", "'Group'", "%%");
        list.forEach(s->log.info(s));
    }

    @Test
    public void updateField() throws Exception {
        System.out.println(sqlServerReplaceWholeDBDao.updateField("巡护排班", "备注", "大王叫我来巡山咯祁连山", "大王叫我来巡山咯兴隆山"));
    }

    @Test
    public void transform() throws Exception{
        long start = System.currentTimeMillis();
        long success = 0;
        long failure = 0;
        List<String> tableNameList = sqlServerReplaceWholeDBDao.queryAllTableName();

        for (int i = 0; i < tableNameList.size(); i++) {
            String tableName = tableNameList.get(i);
//            if(tableName.equals("sys_DeptInfo") || tableName.equals("sys_UserInfo"))
//                continue;
            List<TableInfo> tableInfoList = sqlServerReplaceWholeDBDao.queryInfoByTableName(tableName);
            for (int j = 0; j < tableInfoList.size(); j++) {
                TableInfo info = tableInfoList.get(j);
                String fieldType = info.getData_type();
                String fieldName = info.getColumn_name();
                fieldName = "[" + fieldName + "]";
                if(contentFieldTypes.contains(fieldType)){
                    List<String> oldFieldValueList = sqlServerReplaceWholeDBDao.queryField(tableName, fieldName, "%"+keyWord+"%");
                    /**
                     * oldFieldValueList去重
                     */
                    List<String> oldFieldValueList_NoDuplicate = new ArrayList<>(new HashSet<>(oldFieldValueList));
                    for (int k = 0; k < oldFieldValueList_NoDuplicate.size(); k++) {
                        String oldFieldValue = oldFieldValueList_NoDuplicate.get(k);
                        String newFieldValue = oldFieldValue.replace(keyWord, replaceKeyWord);
                        boolean flag = sqlServerReplaceWholeDBDao.updateField(tableName, fieldName, oldFieldValue, newFieldValue);
                        if(flag){
                            success++;
                            log.info("表:" + tableName + "  更新; 字段:" + fieldName + "; 从:" + oldFieldValue + "--->" + newFieldValue);
                        }else {
                            failure++;
                            log.error("表:" + tableName + "  更新; 字段:" + fieldName + "; 从:" + oldFieldValue + "--->" + newFieldValue);
                        }
                    }
                }
            }
        }
        System.out.println("成功修改" + success + " 处");
        System.out.println("失败修改" + failure + " 处");
        System.out.println("总共耗时:" + (System.currentTimeMillis() - start) + "ms");
    }
}