package demo.com.springboot_fw10.controllers.fe;

import demo.com.springboot_fw10.repositories.ProductRepoForPagingAndSorting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    ProductRepoForPagingAndSorting productRepoForPagingAndSorting;
    @GetMapping("/")
    public String home(Model model){
        //get the last 5 products
        Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
        model.addAttribute("lastProduct", productRepoForPagingAndSorting.findAll(pageable).stream().map(product -> product.mapToDTO()));


        Pageable pageableForBestSellers = PageRequest.of(0, 5, Sort.by("soldCount").descending());
        model.addAttribute("bestSoldProduct", productRepoForPagingAndSorting.findAll(pageableForBestSellers).stream().map(product -> product.mapToDTO()));
        return "fe/home/index";
    }
}
