package org.spring.springboot.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/9/10 16:05
 */
@Data
@Accessors(chain = true)
public class MysqlSystemUser {
    private Serializable id;
    private String username;
    private String password;
    private String nickname;
    private Integer gender;
    private Integer enable;
}
