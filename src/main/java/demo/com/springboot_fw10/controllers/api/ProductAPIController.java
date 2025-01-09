package demo.com.springboot_fw10.controllers.api;

import demo.com.springboot_fw10.dto.ProductDTO;
import demo.com.springboot_fw10.entities.Product;
import demo.com.springboot_fw10.repositories.ProductRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAPIController {
    @Autowired
    ProductRepo productRepo;

    @GetMapping("/api/product/{id}")
    public ProductDTO getByID(@PathVariable Long id) {
        return productRepo.findById(id).map(Product::mapToDTO).orElse(null);
    }

}
