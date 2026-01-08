package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Model.Category;
import com.crud.Model.Order;
import com.crud.Model.Product;
import com.crud.Model.User;
import com.crud.Service.CategoryService;
import com.crud.Service.OrderService;
import com.crud.Service.UserService;
import com.crud.Service.productService;

@RestController
public class MainController {

	@Autowired
	UserService user;
	@Autowired
	productService product;
	@Autowired
	CategoryService category;
	@Autowired
	OrderService order;
	
	//usergate
	@GetMapping("/usergate")
	public List<User> getuser()
	{
		return user.getuser();
	}
	
	//getby id
	@GetMapping("/usergateid/{id}")
	public User getuseid(@PathVariable long id)
	{
		return user.getbyid(id);
	}
	
	//add user 
	@PostMapping("/useradd")
	public User adduser(@RequestBody User obj)
	{
		return user.adduser(obj);
	}
	
	//update user
	@PutMapping("/userupdate/{id}")
	public User userupdate(@PathVariable long id , @RequestBody User obj) throws Exception
	{
		return user.updateuser(id, obj);
	}
	
	//delete user
	@DeleteMapping("/userdelete/{id}")
	public User userdelete(@PathVariable long id) throws Exception
	{
		return user.deleteuser(id);
	}
	
	
	////////////////////////////////////////////////////////////////////
	
	//product
	
	//get product
	@GetMapping("/productget")
	public List<Product> getproduct()
	{
		return product.getproduct();
	}
	
	
	//get by id
	@GetMapping("/productgetid/{id}")
	public Product productgetid(@PathVariable long id) throws Exception
	{
		return product.getproid(id);
	}
	
	//add product
	@PostMapping("/productadd")
	public Product productadd(@RequestBody Product obj)
	{
		return product.addproduct(obj);
	}
	
	//update product
	@PutMapping("/productupdate/{id}")
	public Product productupdate(@PathVariable long id , @RequestBody Product obj) throws Exception
	{
		return product.updateproduct(id, obj);
	}
	
	//delete product
	@DeleteMapping("/productdeleete/{id}")
	public Product productdelete(@PathVariable long id)
	{
		return product.deleteproduct(id);
	}
	
	
	/////////////////////////////////////////////////////////////////
	
	//category
	
	//get category
	@GetMapping("/get")
	public  List<Category> get()
	{
		return category.getCategories();
	}
	
	//getby id
	@GetMapping("/getbyid/{id}")
	public  Category getbyid(@PathVariable long id) throws Exception
	{
		return category.getCategoryById(id);
	}
	
	//add new
	@PostMapping("/add")
	public Category add(@RequestBody Category obj)
	{
		return category.addCategory(obj);
	}
	
	//update
	@PutMapping("/update")
	public Category update(@PathVariable long id ,@RequestBody Category obj) throws Exception
	{
		return category.updateCategory(id, obj);
	}
	
	//delete
	@DeleteMapping("/delete")
	public Category delete(@PathVariable long id ) throws Exception
	{
		return category.deleteCategory(id);
	}
	
	
/////////////////////////////////////////////////////////////////
	
//order
	
	//get orders
	@GetMapping("/orderget")
	public List<Order> orderget()
	{
		return order.getAllOrders();
	}
	
	//getby id orders
	@GetMapping("/ordergrtbyid/{id}")
	public Order ordergetid(@PathVariable long id) throws Exception
	{
		return order.getOrderById(id);
	}
	
	//add order
	@PostMapping("/orderadd")
	public Order orderadd(@RequestBody Order obj)
	{
		return order.addOrder(obj);
	}
	
	//updarorder
	@PutMapping("/orderupdate/{id}")
	public Order orderupdate(@PathVariable long id , @RequestBody Order obj) throws Exception
	{
		return order.updateOrder(id, obj);
	}
	
	//delete order
	@DeleteMapping("/orderdelete/{id}")
	public Order orderdelete(@PathVariable long id ) throws Exception
	{
		return order.deleteOrder(id);
	}
	
	
	
	
	
	
	
}
