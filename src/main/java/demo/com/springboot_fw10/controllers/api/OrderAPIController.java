package demo.com.springboot_fw10.controllers.api;

import demo.com.springboot_fw10.dto.*;
import demo.com.springboot_fw10.entities.Order;
import demo.com.springboot_fw10.entities.Product;
import demo.com.springboot_fw10.repositories.OrderDetailRepo;
import demo.com.springboot_fw10.repositories.OrderRepo;
import demo.com.springboot_fw10.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class OrderAPIController {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    OrderDetailRepo orderDetailRepo;

    @PostMapping("/api/checkout")
    public CheckoutSuccessMessageDTO checkout(@RequestBody PayLoadForOrder orderDTO) {

        System.out.println(orderDTO);
        try {
            Order order = orderRepo.save(orderDTO.getOrderInfo().mapToOrder());
            for (OrderDetailDTO orderDetailDTO : orderDTO.getListDetail()){
                orderDetailDTO.setOrderId(order.getId());
                orderDetailRepo.save(orderDetailDTO.mapToOrderDetail());

            }
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "checkout failed");
        }
        return new CheckoutSuccessMessageDTO("Checkout success!");
    }

}


