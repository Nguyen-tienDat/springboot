package demo.com.springboot_fw10.controllers.fe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CartController {
    @RequestMapping("/cart")
    public String cart() {
        return "fe/cart/index";
    }

    @RequestMapping("/checkout")
    public String checkout() {
        return "fe/cart/checkout";
    }
}
