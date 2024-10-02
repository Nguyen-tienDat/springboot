package demo.com.springboot_fw10.controllers;

import demo.com.springboot_fw10.entities.Product;
import demo.com.springboot_fw10.repositories.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("jpa/product")
public class ProductJPAController {
    @Autowired
    ProductJPARepository productRepository;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "be/product/create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        productRepository.save(product);
        return "redirect:/jpa/product/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "be/product/list";
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "be/product/update";
        } else {
            return "redirect:/jpa/product/list";
        }
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable(name = "id") Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productOptional.get().setId(product.getId());
            productOptional.get().setName(product.getName());
            productOptional.get().setPrice(product.getPrice());
            productOptional.get().setCategory(product.getCategory());
            productRepository.save(productOptional.get());
            return "redirect:/jpa/product/list";
        } else {
            return "redirect:/jpa/product/list";
        }
    }

    @GetMapping("/delete?{id}")
    public String delete(@PathVariable(name = "id") Long id, Model model){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return "redirect:/jpa/product/list";
        }else{
            return "redirect:/jpa/product/list";
        }
    }
}

