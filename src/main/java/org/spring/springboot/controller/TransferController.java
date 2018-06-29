package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public City findByName(@RequestParam(value = "id", required = true) Integer id) {
        return transferService.findByName(id);
    }

}
