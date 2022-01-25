package com.example.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null,"ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Anushka Senarathna", "anushka", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Sadeeepa Dahanayake", "sadeepa", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Nehas Senarathna", "nehas", "1234", new ArrayList<>()));

            userService.addRoleToUser("anushka", "ROLE_MANAGER");
            userService.addRoleToUser("anushka", "ROLE_ADMIN");
            userService.addRoleToUser("anushka", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("sadeepa", "ROLE_MANAGER");
            userService.addRoleToUser("nehas", "ROLE_USER");
        };
    }

}
