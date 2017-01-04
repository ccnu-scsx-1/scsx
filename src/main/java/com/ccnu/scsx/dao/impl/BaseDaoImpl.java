package com.ccnu.scsx.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.ccnu.scsx.dao.IBaseDao;
import com.ccnu.scsx.db.BaseMapper;
import com.ccnu.scsx.utils.ObjectUtils;

public abstract class BaseDaoImpl<T> implements IBaseDao<T> {
  private BaseMapper<T> mapper;
  
  @PostConstruct
  public void init(){
    this.mapper = getMapper();
  }
  
  public void save(T obj){
    mapper.insertSelective(obj);
  }
  
  public List<T> findByIds(List<String> idList) {
    List<T> result = new ArrayList<T>();
    if (ObjectUtils.isEmpty(idList)) {
      return result;
    }
    List<T> listDataInDB = mapper.selectByPrimaryKeys(idList);
    return listDataInDB;
  }

  public void delete(String id){
    mapper.deleteByPrimaryKey(id);
  }
  
  public void update(T obj) {
    mapper.updateByPrimaryKeySelective(obj);
  }
  
  public T findById(String id){
    return mapper.selectByPrimaryKey(id);
  }
  
  public abstract BaseMapper<T> getMapper();

}
