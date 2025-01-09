package demo.com.springboot_fw10.controllers.be;

import demo.com.springboot_fw10.dto.CategoryDTO;
import demo.com.springboot_fw10.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@RequestMapping("admin/category")
@Controller
public class ControllerCategory implements ICRUD<CategoryDTO> {
    @Autowired
    CategoryService categoryService;

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dto", new CategoryDTO());
        return "be/category/create";
    }

    @Override
    @PostMapping("/create")
    public String handleCreate(@ModelAttribute CategoryDTO dto, RedirectAttributes redirectAttributes) {
        categoryService.createCategory(dto, redirectAttributes);
        return "redirect:/admin/category/create";
    }

    @Override
    @GetMapping("/list")
    public String list(Model model) {
        categoryService.listCategory(model);
        return "be/category/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(Long id, Model model) {
        categoryService.getCategory(id, model);
        return "be/category/update";
    }

    @Override
    @PostMapping("/update/{id}")
    public String handleUpdate(Long id, CategoryDTO dto) {
        categoryService.updateCategory(id, dto);
        return "redirect:/admin/category/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/admin/category/list";
    }
}
