package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepo extends CrudRepository<Image, Long> {
}
