package demo.com.springboot_fw10.entities;

import demo.com.springboot_fw10.dto.OrderDTO;
import demo.com.springboot_fw10.dto.OrderDetailDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "order_detail")
@Data
public class OrderDetail {
    @GeneratedValue (generator = "increment")
    @Id
    Long id;

    @Column(name = "order_id")
    Long orderId;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    Double price;

    public OrderDetailDTO mapToDTO(){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setId(id);
        orderDetailDTO.setOrderId(orderId);
        orderDetailDTO.setProductId(productId);
        orderDetailDTO.setQuantity(quantity);
        orderDetailDTO.setPrice(price);
        return orderDetailDTO;

    }
}
