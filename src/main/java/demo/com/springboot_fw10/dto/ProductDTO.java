package demo.com.springboot_fw10.dto;

import demo.com.springboot_fw10.entities.Product;
import lombok.Data;

@Data
public class ProductDTO {
    public Long id;
    public String name;
    public Double price;
    public String description;
    public Double discount;
    public Long categoryId;
    public Long brandId;
    public Integer rateAvg;
    public String thumbnailPath;
    public Long soldCount;

    public Product mapToProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setDescription(description);
        product.setCategoryId(categoryId);
        product.setBrandId(brandId);
        product.setRateAvg(rateAvg);
        product.setSoldCount(soldCount);
        return product;
    }

    public String getThumbnail() {
        return "/uploads/" + thumbnailPath;
    }
}

