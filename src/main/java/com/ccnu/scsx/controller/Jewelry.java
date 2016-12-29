package com.ccnu.scsx.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ccnu.scsx.model.Product;
import com.ccnu.scsx.model.QueryResult;
import com.ccnu.scsx.service.ProductService;

@Controller
public class Jewelry {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/wallpaper/queryByPage")
	@ResponseBody
	QueryResult<?> queryByPage(HttpServletRequest request) {
		String basic = request.getContextPath();
		QueryResult<Product> resultPage = new QueryResult<>();
		resultPage = productService.queryByPage(basic);
	    return resultPage;
	}
	
	@RequestMapping("/wallpaper/singleUpload")
	@ResponseBody
	QueryResult<?> singleUpload(HttpServletRequest request, @RequestParam MultipartFile file,
			String name,String remark,String description,String price) throws IOException {
		String filename = file.getOriginalFilename();// 保存文件到指定文件夹
		String basic = "/static/images/" +filename;
//	    String basic = request.getContextPath() + "/static/images/";
	    String path = request.getRealPath("/static/images/") +File.separator + filename;
	    File target = new File(path);
	    file.transferTo(target);
	    
	    Product product = Product.build(name, remark, description, basic, Double.parseDouble(price));
	    productService.insert(product);
		return queryByPage(request);
	}

}
