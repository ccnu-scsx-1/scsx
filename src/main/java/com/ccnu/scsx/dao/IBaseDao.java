package com.ccnu.scsx.dao;

import java.util.List;

public interface IBaseDao<T> {
  public void save(T obj);

  public void delete(String id);

  public void update(T obj);

  public T findById(String id);
  
  public List<T> findByIds(List<String> idList);
}
