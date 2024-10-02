package demo.com.springboot_fw10.controllers;

import demo.com.springboot_fw10.database.ProductDAO;
import demo.com.springboot_fw10.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.ref.Cleaner.create;

@Controller("product")
@RequestMapping("admin/product")
public class ProductController implements ICrud {
    @Autowired
    @Lazy
    public ProductDAO productDAO;

    @Override
    @GetMapping("/create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "be/product/create";
    }
    @PostMapping("/create")
    public String create (Product product) {
        productDAO.add(product);
        return "redirect:/admin/product/list";
    }

    @GetMapping("/list")
    @Override
    public String list(Model model) {
        ArrayList<Product> products = productDAO.list();
        model.addAttribute("products", products);
        return "be/product/list";
    }

    @Override
    @GetMapping("/update/{id}")
    public String update(@PathVariable(name = "id") int id, Model model) {
        Product product = productDAO.get(id);
        model.addAttribute("product", product);
        return "be/product/update";
    }
    @PostMapping("/update/{id}")
    public String update (Product product) {
        productDAO.update(product);
        return "redirect:/admin/product/list";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        productDAO.remove(id);
        return "redirect:/admin/product/list";
    }
}