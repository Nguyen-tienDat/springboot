package demo.com.springboot_fw10.dto;

import lombok.Data;

import java.util.List;
@Data
public class PayLoadForOrder {
    OrderDTO orderInfo;
    List<OrderDetailDTO> listDetail;
}
