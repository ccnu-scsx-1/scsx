package com.ccnu.scsx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ccnu.scsx.model.Product;
import com.ccnu.scsx.model.QueryResult;

@Controller
public class Test {

	@RequestMapping("/test/queryByPage")
	@ResponseBody
	QueryResult<?> queryByPage(HttpServletRequest request) {
		String basic = request.getContextPath();
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setId(1);
		product.setImg(basic+"/static/images/ccnu_logo.png");
		product.setName("Joban");
		product.setRemark("111");
		products.add(product);
		QueryResult<Product> resultPage = new QueryResult<>();
		resultPage.setTotal((long) 1);
	    resultPage.setRows(products);
	    return resultPage;
	}

}
