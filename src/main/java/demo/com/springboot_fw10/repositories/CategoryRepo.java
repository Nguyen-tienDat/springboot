package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
    @Query("SELECT COUNT(p) FROM users p")
    int getTotalRecords();
}