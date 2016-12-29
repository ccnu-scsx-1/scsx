package com.ccnu.scsx.db;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper<T> {
  public void insert(T obj);

  public void insertSelective(T obj);

  public void deleteByPrimaryKey(Long id);

  public void updateByPrimaryKey(T obj);

  public void updateByPrimaryKeySelective(T obj);

  public T selectByPrimaryKey(Long id);

  public List<T> selectByPrimaryKeys(@Param("ids") List<Long> ids);
}
