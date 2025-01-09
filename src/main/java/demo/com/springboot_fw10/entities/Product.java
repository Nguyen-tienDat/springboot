package demo.com.springboot_fw10.entities;

import demo.com.springboot_fw10.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "increment")
    Long id;

    String name;
    String description;
    Double price;
    Double discount;

    @Column(name = "category_id")
    Long categoryId;

    @Column(name = "brand_id")
    Long brandId;

    @Column(name = "rate_avg")
    Integer rateAvg;

    @Column(name = "sold_count")
    Long soldCount;

    //map one to many of image
    @OneToMany(mappedBy = "productId")
    Collection<Image> images;


    public ProductDTO mapToDTO(){
        ProductDTO dto = new ProductDTO();
        dto.id = id;
        dto.name = name;
        dto.price = price;
        dto.discount = discount;
        dto.description = description;
        dto.categoryId = categoryId;
        dto.brandId = brandId;
        dto.rateAvg = rateAvg;
        dto.soldCount = soldCount;
        dto.thumbnailPath = images.stream().findFirst().get().getPath();
        return dto;
    }

}