package org.spring.springboot.service.impl;

import org.spring.springboot.dao.sqlserver.CityDao;
import org.spring.springboot.dao.mysql.UserDao;
import org.spring.springboot.domain.City;
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
    private CityDao cityDao; // 从数据源

    @Override
    public City findByName(Integer id) {
//        User user = userDao.findByName(id);
        City city = cityDao.findByName(id);
        return city;
    }
}
