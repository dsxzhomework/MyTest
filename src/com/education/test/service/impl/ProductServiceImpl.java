package com.education.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.test.dao.ProductDao;
import com.education.test.model.product;
import com.education.test.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao productDao;
	
	//获取全部产品列表
	public List<product> getAllProduct(){
		List<product> list;
		list=productDao.getAll();
//		System.out.println("图片路经为"+list.get(0).getImageSrc());
		return list;
	}
	//查找产品详情
	public product getProductInfo(long productId){
	product temp=new product();
	temp=productDao.getById(product.class, productId);
	return temp;
	}
	
}
