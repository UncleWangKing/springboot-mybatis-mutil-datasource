package org.spring.springboot.service;

import org.spring.springboot.domain.XiaoBan;

import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
public interface TransferService {

    XiaoBan queryById(Integer id);

    List<XiaoBan> queryList();
}
