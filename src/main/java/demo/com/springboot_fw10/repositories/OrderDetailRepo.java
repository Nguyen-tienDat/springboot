package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepo extends CrudRepository<OrderDetail, Long> {
}
