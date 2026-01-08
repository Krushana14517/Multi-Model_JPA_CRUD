package com.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Model.Product;
import com.crud.Repository.ProductRepo;

@Service
public class productService {

	@Autowired
	ProductRepo productrepo;
	
	
	//get
	public List<Product> getproduct()
	{
		return productrepo.findAll();
	}
	
	
	//getbyid
	public Product getproid(long id) throws Exception
	{
		Product data = productrepo.findById(id).orElseThrow(()-> new Exception("this is not present"));
		return data;
	}
	
	// add new
	public Product addproduct(Product product)
	{
			return 	productrepo.save(product);
	}
	
	//update 
	public Product updateproduct(long id , Product data) throws Exception
	{
	Product	product=productrepo.findById(id).orElseThrow(()->new Exception("id not present !!"));
		product.setProductId(id);
		product.setName(data.getName());
		product.setPrice(data.getPrice());
		productrepo.save(product);
		return product;
	
	}
	
	
	
	//delete
	public Product deleteproduct(long id)
	{
		Product data = productrepo.findById(id).orElseThrow();
		productrepo.deleteById(id);
		return data;
	}
	
	
	
	
	
}
