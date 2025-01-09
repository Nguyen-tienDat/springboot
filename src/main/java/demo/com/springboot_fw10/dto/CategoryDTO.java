package demo.com.springboot_fw10.dto;

import demo.com.springboot_fw10.entities.Category;
import lombok.Data;

@Data
public class CategoryDTO {
    public Long id;
    public String name;
    public String description;

    public Category mapToCategory(){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        return category;
    }

}
