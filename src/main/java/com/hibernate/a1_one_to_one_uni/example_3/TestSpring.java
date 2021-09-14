package com.hibernate.a1_one_to_one_uni.example_3;

import com.hibernate.a1_one_to_one_uni.example_3.model.Address;
import com.hibernate.a1_one_to_one_uni.example_3.model.User;
import com.hibernate.a1_one_to_one_uni.example_3.repository.AddressRepository;
import com.hibernate.a1_one_to_one_uni.example_3.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class TestSpring {
    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(TestSpring.class);

        UserRepository userRepository = context.getBean("user", UserRepository.class);
        AddressRepository addressRepository = context.getBean("addressRepository",AddressRepository.class);

/*
        Address address_one = new Address("Istanbul","Sabuncu","Kayfli");

        User user_one = new User("Zlatan Ibrahimic",address_one);

        userRepository.save(user_one);
*/
        //update user
/*
        Address address_two = new Address("Istanbul","Ramani","Qods");
        User user_one_update = new User(1,"Lionel Messi",address_two);

        userRepository.save(user_one_update);
*/
        /** add new address for user 1

        List<User> userList = userRepository.findAll();

        //find by one
        System.out.println("find by id " + userRepository.findById(1).get().getFullName());


        System.out.println(userList.get(0).getFullName());


        User user_one = userRepository.findById(1).get();
        System.out.println(user_one.getFullName());
        Address address_three = new Address("Yevlax", "Yevlaxxana","bazdiq",user_one);

        addressRepository.save(address_three);
         */

//        User user_one = new User("Kafka");
//        System.out.println(user_one.getFullName());
//        Address address_three = new Address("Yevlax", "Yevlaxxana","bazdiq",user_one);
//
//        addressRepository.save(address_three);


        System.out.println(addressRepository.findById(6).get().getUser().getFullName());

        context.close();

    }
}
