package demo.com.springboot_fw10.entities;

import demo.com.springboot_fw10.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity(name = "users")
@Data
public class User {

    public static final int ROLE_ADMIN = 0;
    public static final int ROLE_USER = 1;
    @GeneratedValue(generator = "increment")
    @Id
    Long id;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "password")
    String password;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "address")
    String address;

    @Column(name = "role")
    Integer role;

    public UserDTO mapToDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setFullName(fullName);
        userDTO.setPassword(password);
        userDTO.setPhone(phone);
        userDTO.setEmail(email);
        userDTO.setAddress(address);
        userDTO.setRole(role);
        if (this.role == ROLE_ADMIN){
            userDTO.setRoleLabel("Admin");
        }
        else {
            userDTO.setRoleLabel("User");
        }
        return userDTO;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Collection<Role> roles;

}