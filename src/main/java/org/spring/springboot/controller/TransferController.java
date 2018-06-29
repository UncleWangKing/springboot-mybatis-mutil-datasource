package org.spring.springboot.controller;

import org.spring.springboot.domain.XiaoBan;
import org.spring.springboot.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/xb", method = RequestMethod.GET)
    public XiaoBan queryById(@RequestParam(value = "id", required = true) Integer id) {
        return transferService.queryById(id);
    }

    @RequestMapping(value = "/api/xb/list", method = RequestMethod.GET)
    public List<XiaoBan> queryList() {
        return transferService.queryList();
    }

}
