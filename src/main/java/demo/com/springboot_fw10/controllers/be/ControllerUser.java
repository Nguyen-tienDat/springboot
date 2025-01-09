package demo.com.springboot_fw10.controllers.be;

import demo.com.springboot_fw10.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import demo.com.springboot_fw10.services.UserService;

@Controller
@RequestMapping("/admin/user")
public class ControllerUser implements ICRUD<UserDTO> {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("dto", new UserDTO());
        return "be/user/create";
    }
    @Override
    @PostMapping("/create")
    public String handleCreate(@ModelAttribute UserDTO userDTO, RedirectAttributes redirectAttributes) {
        userService.createUser(userDTO, redirectAttributes);
        return "redirect:/admin/user/create";
    }

    @Override
    @GetMapping("/list")
    public String list(Model model){
        userService.listUser(model);
        return "be/user/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        userService.getUser(id, model);
        return "be/user/update";
    }

    @Override
    @PostMapping("/update/{id}")
    public String handleUpdate(@PathVariable Long id, @ModelAttribute UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return "redirect:/admin/user/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/user/list";
    }

}

