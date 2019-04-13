package com.cy.mapper;

import com.cy.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alan
 * @since 2019-04-11
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
