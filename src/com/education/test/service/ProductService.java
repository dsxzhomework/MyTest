package com.education.test.service;

import java.util.List;

import com.education.test.model.product;

public interface ProductService {
	public List<product> getAllProduct();
	public product getProductInfo(long productId);
}
