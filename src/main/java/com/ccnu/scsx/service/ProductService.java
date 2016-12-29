package com.ccnu.scsx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccnu.scsx.dao.ProductDao;
import com.ccnu.scsx.model.Product;
import com.ccnu.scsx.model.QueryResult;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	public QueryResult<Product> queryByPage(String basic) {
		List<Product> products = productDao.queryPage();
		Long total = (long) products.size();
		for (Product product : products){
			product.setImg(basic + product.getImg());
		}
		QueryResult<Product> resultPage = new QueryResult<>();
		resultPage.setTotal(total);
	    resultPage.setRows(products);
	    return resultPage;
	}
	
	public void insert(Product product) {
		productDao.insert(product);
	}
	
}
