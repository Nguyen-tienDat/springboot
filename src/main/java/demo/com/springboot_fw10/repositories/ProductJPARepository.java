package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
}
