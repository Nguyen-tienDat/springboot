package demo.com.springboot_fw10.services;

import demo.com.springboot_fw10.dto.ProductDTO;
import demo.com.springboot_fw10.entities.Image;
import demo.com.springboot_fw10.entities.Product;
import demo.com.springboot_fw10.repositories.ImageRepo;
import demo.com.springboot_fw10.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    // Đọc cấu hình thư mục tải lên từ file application.properties
    @Value("${UPLOAD_DIR}")
    private String UPLOAD_DIR;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ImageRepo imageRepo;

    public void createProduct(ProductDTO productDTO, MultipartFile[] files, RedirectAttributes redirectAttributes) {
        try {
            ArrayList<String> filePaths = new ArrayList<>();
            // Check if file is empty or null
            if (files == null || files.length == 0) {
                redirectAttributes.addFlashAttribute("error_message", "No files uploaded");
                return;
            }

            //Save file
            for (MultipartFile uploadFile : files) {
                if (uploadFile.isEmpty()) {
                    continue;  //Passed through if file is empty
                }

                // Create folder based on date to save file
                Date date = new Date();
                String dateFolder = (1900 + date.getYear()) + "-" + (date.getMonth() + 1) + "-" + date.getDate(); // Lấy năm, tháng, ngày
                File folder = new File(UPLOAD_DIR + "/" + dateFolder);
                if (!folder.exists()) {
                    folder.mkdirs();  // Create folder if it's empty
                }

                // Create unique file
                String fileName = date.getTime() + "_" + uploadFile.getOriginalFilename();
                File file = new File(folder, fileName);

                // Save file to folder
                uploadFile.transferTo(file);
                filePaths.add(dateFolder + "/" + fileName);
            }
            try {
                Product savedProduct = productRepo.save(productDTO.mapToProduct());

                //save image to product data
                for (int i = 0; i < filePaths.size(); i++) {
                    Image image = new Image();
                    image.setPath(filePaths.get(i));
                    image.setProductId(savedProduct.getId());
                    if (i == 0) {
                        image.setIsThumbnail(1);
                    }
                    image.setIsThumbnail(1);
                    imageRepo.save(image);
                }
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error_message", e.getMessage());
                //delete file
                for(String filePath : filePaths) {
                    new File(UPLOAD_DIR + "/" + filePath).delete();
                }
                throw e;
            }

            redirectAttributes.addFlashAttribute("success_message", "Product created successfully");
        } catch (IOException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error_message", "Error uploading files");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error_message", "Product creation failed");
        }
    }

    public void listProduct(Model model) {
        ArrayList<ProductDTO> productDTOList = new ArrayList<>();
        productRepo.findAll().forEach(product -> {
            productDTOList.add(product.mapToDTO());
        });
        model.addAttribute("products", productDTOList);
    }

    public void getProduct(Long id, Model model) {
        productRepo.findById(id).ifPresent(product -> {
            model.addAttribute("dto", product.mapToDTO());
        });
    }

    public void deleteProduct(Long id) {
        productRepo.findById(id).ifPresent(product -> {
            productRepo.delete(product);
        });
    }

    public void updateProduct(Long id, ProductDTO productDTO) {
        productRepo.findById(id).ifPresent(product -> {
            productRepo.save(productDTO.mapToProduct());
        });
    }
}
