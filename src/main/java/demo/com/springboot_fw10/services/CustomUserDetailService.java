package demo.com.springboot_fw10.services;

import demo.com.springboot_fw10.entities.User;
import demo.com.springboot_fw10.repositories.UserAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserAuthRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().stream().forEach(role -> {
            System.out.println("Role: " + role.getName());
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
