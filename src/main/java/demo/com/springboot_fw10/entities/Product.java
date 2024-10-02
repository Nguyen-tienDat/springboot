package demo.com.springboot_fw10.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name  = "product")
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;
    private String category;
}
