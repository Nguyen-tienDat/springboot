package demo.com.springboot_fw10.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Collection;

@Entity(name = "roles")
@Data
public class Role {
    @GeneratedValue(generator = "increment")
    @Id
    Long id;

    String name;
    @ManyToMany(mappedBy = "roles")
    Collection<User> users;
}
