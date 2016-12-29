package com.ccnu.scsx.mapper;

import java.util.List;

import com.ccnu.scsx.annotation.Mapper;
import com.ccnu.scsx.model.Product;

@Mapper
public interface ProductMapper {
	List<Product> queryByPage();
	
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Product record);
    
    void insert(Product product);
    
}