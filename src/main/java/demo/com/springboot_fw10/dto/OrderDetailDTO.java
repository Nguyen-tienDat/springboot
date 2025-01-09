package demo.com.springboot_fw10.dto;

import demo.com.springboot_fw10.entities.OrderDetail;
import lombok.Data;

@Data
public class OrderDetailDTO {
    Long id;
    Long orderId;
    Long productId;
    Integer quantity;
    Double price;

    public OrderDetail mapToOrderDetail(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetail.setOrderId(orderId);
        orderDetail.setProductId(productId);
        orderDetail.setPrice(price);
        return orderDetail;
    }

}
