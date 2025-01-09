package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
    @Query("SELECT COUNT(p) FROM products p")
    int getTotalRecords();
}
