package com.ccnu.scsx.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ccnu.scsx.mapper.ProductMapper;
import com.ccnu.scsx.model.Product;

@Repository
public class ProductDao {
	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> queryPage() {
		return productMapper.queryByPage();
	}
	
	public void insert(Product product) {
		productMapper.insert(product);
	}

}
