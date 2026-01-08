package com.crud.Service;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Model.Order;
import com.crud.Repository.OrderRepo;
@Service
public class OrderService {

	@Autowired
    private OrderRepo orderRepo;
	
	
	// 1. Get All Orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    // 2. Get Order By ID
    public Order getOrderById(long id) throws Exception {
        return orderRepo.findById(id)
                .orElseThrow(() -> new Exception("Order with ID " + id + " not found!"));
    }

    // 3. Add New Order
    public Order addOrder(Order order) {
        // If orderDate is null, we can ensure it's set before saving
//        if (order.getOrderDate() == null) {
//            order.setOrderDate(LocalDate.now());
//        }
        return orderRepo.save(order);
    }

    // 4. Update Order
    public Order updateOrder(long id, Order data) throws Exception {
        Order existingOrder = orderRepo.findById(id)
                .orElseThrow(() -> new Exception("Order ID not present !!"));

        // Update fields using setters (provided by Lombok @Data)
        existingOrder.setOrderId(id);
        existingOrder.setUserId(data.getUserId());
        existingOrder.setPrice(data.getPrice());
    //    existingOrder.setOrderDate(data.getOrderDate());

        return orderRepo.save(existingOrder);
    }

    // 5. Delete Order
    public Order deleteOrder(long id) throws Exception {
        Order data = orderRepo.findById(id)
                .orElseThrow(() -> new Exception("Order not found for deletion"));
        
        orderRepo.deleteById(id);
        return data;
    }
	
	
		
}
