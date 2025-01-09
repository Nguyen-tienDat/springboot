package demo.com.springboot_fw10.dto;

import lombok.Data;

@Data
public class CheckoutSuccessMessageDTO {
    public String message;

    public CheckoutSuccessMessageDTO(String message) {
        this.message = message;
    }
}
