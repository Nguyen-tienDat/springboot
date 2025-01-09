package demo.com.springboot_fw10.controllers.be;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface ICRUDForProduct<DTO> {
    public String create(Model model);

    @GetMapping("/create")
    public String handleCreate(@ModelAttribute DTO dto, @RequestParam("images") MultipartFile[] images, RedirectAttributes redirectAttributes);

    public String list (Model model);

    public String update(@PathVariable(name = "id") Long id, Model model);


    public String handleUpdate(@PathVariable(name = "id") Long id, @ModelAttribute DTO dto);

    @GetMapping("/delete{id}")
    public String delete(@PathVariable(name = "id") Long id);
}
