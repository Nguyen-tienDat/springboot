package demo.com.springboot_fw10.repositories;

import demo.com.springboot_fw10.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
