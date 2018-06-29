package org.spring.springboot.service.impl;

import org.spring.springboot.dao.sqlserver.SqlServerXiaoBanDao;
import org.spring.springboot.dao.mysql.MysqlXiaoBanDao;
import org.spring.springboot.domain.XiaoBan;
import org.spring.springboot.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private MysqlXiaoBanDao mysqlXiaoBanDao; // 主数据源

    @Autowired
    private SqlServerXiaoBanDao sqlServerXiaoBanDao; // 从数据源

    @Override
    public XiaoBan queryById(Integer id) {
//        User user = mysqlXiaoBanDao.findByName(id);
        return sqlServerXiaoBanDao.queryById(id);
    }

    @Override
    public List<XiaoBan> queryList() {
        return sqlServerXiaoBanDao.queryList();
    }
}
