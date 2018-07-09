package org.spring.springboot.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/7/9 15:32
 */
@Data
public class LinBan {
    private Long id;
    private String shape;
    private Integer xianju;
    private Integer xiangzhenchang;
    private Integer xingzhengcun;
    private Integer linbanhao;
    private String keyWord;
    private Integer suoshuxian;
    private Integer gongnengqu;
    private BigDecimal mianji;
    private BigDecimal maxX;
    private BigDecimal maxY;
    private BigDecimal minX;
    private BigDecimal minY;
}
