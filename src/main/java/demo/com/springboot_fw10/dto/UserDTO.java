package demo.com.springboot_fw10.dto;

import demo.com.springboot_fw10.entities.User;
import lombok.Data;

@Data
public class UserDTO implements Dto {
    public String password;
    public String fullName;
    public String email;
    public String phone;
    public String address;
    public Integer role;
    public Long id;
    public String roleLabel;

    public User mapToUSer(){
        User user = new User();
        user.setPassword(password);
        user.setAddress(address);
        user.setFullName(fullName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
        return user;
    }

}
