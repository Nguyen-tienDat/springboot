package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
