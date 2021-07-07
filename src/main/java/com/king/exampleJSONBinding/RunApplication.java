package com.king.exampleJSONBinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.king.exampleJSONBinding.model.Address;
import com.king.exampleJSONBinding.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class RunApplication {
    public static void main(String[] args){
        SpringApplication.run(RunApplication.class);
        System.out.println("Start");
        getData();
    }

    public static void getData(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            Student theStudent = mapper.readValue(
                    new File("C:\\Users\\Rustam\\Desktop\\Learning programing\\Backend project\\LessonSpring\\src\\main\\resources\\data\\student.json"), Student.class
            );

            System.out.println("Name: " + theStudent.getName());
            System.out.println("Surname : " + theStudent.getSurname());

            Address theAddress = theStudent.getAddress();

            System.out.println("city: " + theAddress.getCity());

            for(String lang : theStudent.getLanguages()){
                System.out.println(lang);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
