package org.spring.springboot.service;

import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
public interface TransferService {

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName
     * @return
     */
    City findByName(Integer userName);
}
