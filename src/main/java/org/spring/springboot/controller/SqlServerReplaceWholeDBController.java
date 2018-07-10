package org.spring.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.spring.springboot.dao.sqlserver.SqlServerReplaceWholeDBDao;
import org.spring.springboot.domain.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/test")
@Slf4j
public class SqlServerReplaceWholeDBController {
    private List<String> excludeTables = Arrays.asList("By", "flv", "GG", "KKK");
    private List<String> contentFieldTypes = Arrays.asList("varchar", "nvarchar");
    private String keyWord = "祁连山";
    private String replaceKeyWord = "兴隆山";
    @Autowired
    private SqlServerReplaceWholeDBDao sqlServerReplaceWholeDBDao; // 主数据源

    @RequestMapping(method = RequestMethod.GET)
    public List<String> transform() throws Exception{
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
        List<String> resultList = new ArrayList<>();
        String str1 = "成功修改" + success + " 处";
        String str2 = "失败修改" + failure + " 处";
        String str3 = "总共耗时:" + (System.currentTimeMillis() - start) + "ms";
        resultList.add(str1);
        resultList.add(str2);
        resultList.add(str3);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        return resultList;
    }
}
