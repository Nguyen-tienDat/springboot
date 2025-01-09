package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepoForPagingAndSorting extends PagingAndSortingRepository<Product, Long> {
}
