package org.spring.springboot.dao.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.HLSLinBan;

import java.util.List;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 11:25
 */
@Mapper
public interface MysqlLinBanDao {

    Boolean batchSave(@Param("list") List<HLSLinBan> list);

    Boolean save(@Param("item") HLSLinBan item);
}
