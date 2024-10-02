package demo.com.springboot_fw10.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface ICrud {
    public String create(Model model);

    public String list (Model model);

    public String update(@PathVariable(name = "id") int id, Model model);


    public String delete(@PathVariable(name = "id") int id);
}
