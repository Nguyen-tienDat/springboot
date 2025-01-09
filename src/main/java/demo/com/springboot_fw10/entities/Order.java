package demo.com.springboot_fw10.entities;

import demo.com.springboot_fw10.dto.OrderDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.awt.*;

@Entity(name = "orders")
@Data
public class Order {
    @GeneratedValue(generator = "increment")
    @Id
    Long id;

    @Column(name = "sub_total")
    Double subTotal;

    @Column(name = "total")
    Double total;

    @Column(name = "tax")
    Double tax;

    @Column(name = "shipping_fee")
    Double shippingFee;

    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @Column(name = "status")
    Integer status;

    @Column(name = "full_name")
    String fullName;

    //map to DTO
    public OrderDTO mapToDTO(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(id);
        orderDTO.setSubTotal(subTotal);
        orderDTO.setTotal(total);
        orderDTO.setTax(tax);
        orderDTO.setPhone(phone);
        orderDTO.setAddress(address);
        orderDTO.setStatus(status);
        orderDTO.setFullName(fullName);
        orderDTO.setShippingFee(shippingFee);
        return orderDTO;
    }
}
