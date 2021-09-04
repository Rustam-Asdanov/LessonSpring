package com.king.returnExample.controller;

import com.king.returnExample.model.Student;
import com.king.returnExample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping()
    private String getIndex(Model model){
        model.addAttribute("newStudent",new Student());
        model.addAttribute("student",new Student());

        return "/returnExample/main";
    }

    @GetMapping("/getStudentInfo")
    private String getInfoPage(@ModelAttribute("newStudent") Student student, Model model){

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAge());
        System.out.println(student.getEmail());
        System.out.println(student.getPassword());

        studentRepository.save(student);
        model.addAttribute("studentInfo",student);

        return "/returnExample/information";
    }

    @GetMapping("/getStudentPage")
    private String getMainPage(@ModelAttribute("student") Student student, Model model){
        model.addAttribute("student",studentRepository.findById(1));

        return "/returnExample/studentPage";
    }
}
