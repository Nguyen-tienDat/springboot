package demo.com.springboot_fw10.services;

import demo.com.springboot_fw10.dto.UserDTO;
import demo.com.springboot_fw10.entities.User;
import demo.com.springboot_fw10.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public void createUser(UserDTO userDTO, RedirectAttributes redirectAttributes) {
        try{
            userRepo.save(userDTO.mapToUSer());
            redirectAttributes.addFlashAttribute("success_message", "User created successfully");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error_message", "User creation failed");
        }
    }

    public void listUser(Model model){
        List<UserDTO> userDTOS = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            userDTOS.add(user.mapToDTO());
        });
        model.addAttribute("users", userDTOS);
    }

    public void getUser(Long id, Model model){
        userRepo.findById(id).ifPresent(user -> {
            model.addAttribute("dto", user.mapToDTO());
        });
    }

    public void deleteUser(Long id) {
        userRepo.findById(id).ifPresent(user -> {
            userRepo.delete(user);
        });
    }

    public void updateUser(Long id, UserDTO userDTO) {
        userRepo.findById(id).ifPresent(user -> {
            userRepo.save(userDTO.mapToUSer());
        });
    }
}
