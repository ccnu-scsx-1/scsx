package com.ccnu.scsx.mapper;

import com.ccnu.scsx.model.total;

public interface totalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(total record);

    int insertSelective(total record);

    total selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(total record);

    int updateByPrimaryKey(total record);
}