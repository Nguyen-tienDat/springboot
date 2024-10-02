package demo.com.springboot_fw10.controllers;

import demo.com.springboot_fw10.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller("HomeController")
public class HomeController{
    @GetMapping("/")
    public String home(Model model){
        Product product = new Product();
        product.id =1;
        product.name="Product 1";
        product.price = 100.0f;
        model.addAttribute("tittle", "Home Page");
        model.addAttribute("product", product);

        ArrayList<String> languages = new ArrayList<>();
        languages.add("java");
        languages.add("python");
        model.addAttribute("languages", languages);
        model.addAttribute("age", 12);
        return "fe/home";

    }
    @GetMapping("/product-detail")
    public String productDetail(Model model){
        Product product = new Product();
        product.id =1;
        product.name="Product 1";
        product.price = 100.0f;
        model.addAttribute("Product", "Product Detail");
        return "fe/product-detail";
    }
}
