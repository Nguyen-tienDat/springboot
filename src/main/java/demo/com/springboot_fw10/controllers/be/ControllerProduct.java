package demo.com.springboot_fw10.controllers.be;

import demo.com.springboot_fw10.dto.CategoryDTO;
import demo.com.springboot_fw10.dto.ProductDTO;
import demo.com.springboot_fw10.entities.Category;
import demo.com.springboot_fw10.repositories.CategoryRepo;
import demo.com.springboot_fw10.services.CategoryService;
import demo.com.springboot_fw10.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin/product")
public class ControllerProduct implements ICRUDForProduct<ProductDTO> {
    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @Override
    @GetMapping("/create")
    public String create(Model model) {
        ArrayList<CategoryDTO> categoryDTOS = new ArrayList<>();
        //get category
       categoryRepo.findAll().forEach(category -> {
           categoryDTOS.add(category.mapToDTO());
       });
       model.addAttribute("categories", categoryDTOS);
       model.addAttribute("dto", new ProductDTO());
        return "be/product/create";
    }

    @Override
    @PostMapping("/create")
    public String handleCreate(ProductDTO productDTO,
                               @RequestParam(value = "images[]") MultipartFile[] images,
                               RedirectAttributes redirectAttributes) {
        for (int i = 0; i < images.length; i++) {
            System.out.println("images["+i+"]="+images[i].getOriginalFilename());
        }
        System.out.println("ProductName"+ productDTO.getName());
        productService.createProduct(productDTO, images, redirectAttributes);
        return "redirect:/admin/product/create";
    }

    @Override
    @GetMapping("/list")
    public String list(Model model) {
        productService.listProduct(model);
        return "be/product/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(Long id, Model model) {
        productService.getProduct(id, model);
        return "be/product/update";
    }

    @Override
    @PostMapping("/update/{id}")
    public String handleUpdate(Long id, ProductDTO dto) {
        productService.updateProduct(id, dto);
        return "redirect:/admin/product/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/product/list";
    }
}
