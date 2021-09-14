package com.hibernate.a1_one_to_one_uni.example_2;

import com.hibernate.a1_one_to_one_uni.example_2.model.User;
import com.hibernate.a1_one_to_one_uni.example_2.model.UserDetails;
import com.hibernate.a1_one_to_one_uni.example_2.repository.UserDetailsRepository;
import com.hibernate.a1_one_to_one_uni.example_2.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainClass {

    public static void main(String[] args){

        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(MainClass.class);

        UserRepository userRepository =
                configurableApplicationContext.getBean(UserRepository.class);

        UserDetailsRepository userDetailsRepository =
                configurableApplicationContext.getBean(UserDetailsRepository.class);

        UserDetails userOneDetails = new UserDetails("Bolivia","30 february", "MasterPro");

        User userOne = new User("Mamed","Mamedov", userOneDetails);

        userRepository.save(userOne);
    }


}
