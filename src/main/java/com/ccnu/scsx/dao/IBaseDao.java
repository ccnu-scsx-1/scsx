package com.ccnu.scsx.dao;

import java.util.List;

public interface IBaseDao<T> {
  public void save(T obj);

  public void delete(Long id);

  public void update(T obj);

  public T findById(Long id);
  
  public List<T> findByIds(List<Long> idList);
}
