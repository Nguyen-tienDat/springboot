package demo.com.springboot_fw10.services;

import demo.com.springboot_fw10.dto.CategoryDTO;

import demo.com.springboot_fw10.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void createCategory(CategoryDTO categoryDTO, RedirectAttributes redirectAttributes) {
        try{
            categoryRepo.save(categoryDTO.mapToCategory());
            redirectAttributes.addFlashAttribute("success_message", "category created successfully");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error_message", "category creation failed");
        }
    }

    public void listCategory(Model model){
        ArrayList<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryRepo.findAll().forEach(category -> {
           categoryDTOList.add(category.mapToDTO());
        });
        model.addAttribute("categories", categoryDTOList);
    }

    public void getCategory(Long id, Model model){
        categoryRepo.findById(id).ifPresent(category -> {
            model.addAttribute("dto", category.mapToDTO());
        });
    }

    public void deleteCategory(Long id) {
        categoryRepo.findById(id).ifPresent(category -> {
            categoryRepo.delete(category);
        });
    }

    public void updateCategory(Long id, CategoryDTO categoryDTO) {
        categoryRepo.findById(id).ifPresent(category -> {
            categoryRepo.save(categoryDTO.mapToCategory());
        });
    }
}
