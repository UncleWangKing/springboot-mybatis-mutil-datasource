package org.spring.springboot.service.impl;

import org.spring.springboot.dao.sqlserver.XiaoBanDao;
import org.spring.springboot.dao.mysql.UserDao;
import org.spring.springboot.domain.XiaoBan;
import org.spring.springboot.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private XiaoBanDao xiaoBanDao; // 从数据源

    @Override
    public XiaoBan queryById(Integer id) {
//        User user = userDao.findByName(id);
        XiaoBan xiaoBan = xiaoBanDao.queryById(id);
        return xiaoBan;
    }
}
