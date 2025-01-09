package demo.com.springboot_fw10.entities;

import demo.com.springboot_fw10.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    Long id;
    String name;
    String description;

    public CategoryDTO mapToDTO(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(id);
        categoryDTO.setName(name);
        categoryDTO.setDescription(description);
        return categoryDTO;
    }
}