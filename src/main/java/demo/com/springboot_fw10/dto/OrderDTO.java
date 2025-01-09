package demo.com.springboot_fw10.dto;

import demo.com.springboot_fw10.entities.Order;
import lombok.Data;

@Data
public class OrderDTO {
    Long id;
    Double subTotal;
    Double total;
    Double tax;
    Double shippingFee;
    Integer userId;
    String fullName;
    String phone;
    String address;
    Integer status = 1;

    //map to entity
    public Order mapToOrder(){
        Order order = new Order();
        order.setId(id);
        order.setSubTotal(subTotal);
        order.setTotal(total);
        order.setTax(tax);
        order.setFullName(fullName);
        order.setPhone(phone);
        order.setAddress(address);
        order.setStatus(status);
        order.setShippingFee(shippingFee);
        return order;
    }
}
