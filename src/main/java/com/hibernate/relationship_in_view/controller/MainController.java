package com.hibernate.relationship_in_view.controller;

import com.hibernate.relationship_in_view.model.Lessons;
import com.hibernate.relationship_in_view.model.Student;
import com.hibernate.relationship_in_view.model.StudentDetail;
import com.hibernate.relationship_in_view.model.Teacher;
import com.hibernate.relationship_in_view.repository.LessonsRepository;
import com.hibernate.relationship_in_view.repository.StudentDetailRepository;
import com.hibernate.relationship_in_view.repository.StudentRepository;
import com.hibernate.relationship_in_view.repository.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    private LessonsRepository lessonsRepository;
    private StudentRepository studentRepository;
    private StudentDetailRepository studentDetailRepository;
    private TeacherRepository teacherRepository;

    public MainController(LessonsRepository lessonsRepository,
                          StudentRepository studentRepository,
                          StudentDetailRepository studentDetailRepository,
                          TeacherRepository teacherRepository) {
        this.lessonsRepository = lessonsRepository;
        this.studentRepository = studentRepository;
        this.studentDetailRepository = studentDetailRepository;
        this.teacherRepository = teacherRepository;
    }

    @GetMapping
    public String getPage(Model model){

        model.addAttribute("student", new Student());
        model.addAttribute("student_detail",new StudentDetail());
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("lessons",lessonsRepository.findAll());
        model.addAttribute("students",studentRepository.findAll());

        return "relationship_in_view/main";
    }

    @GetMapping("/addStudent")
    public String addStudent(
            @ModelAttribute("student") Student theStudent,
            @ModelAttribute("student_detail") StudentDetail theStudentDetail
    ){
        theStudent.setStudentDetail(theStudentDetail);
        studentRepository.save(theStudent);


        return "redirect:/main";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(
            @ModelAttribute("teacher") Teacher theTeacher,
            @RequestParam("lesson_one") String lesson_one,
            @RequestParam("lesson_two") String lesson_two,
            @RequestParam("lesson_three") String lesson_three
            ){

        System.out.println(lesson_one);

        Lessons lessonOne = new Lessons(lesson_one);
        Lessons lessonTwo = new Lessons(lesson_two);
        Lessons lessonThree = new Lessons(lesson_three);

        theTeacher.addLesson(lessonOne);
        theTeacher.addLesson(lessonTwo);
        theTeacher.addLesson(lessonThree);

        teacherRepository.save(theTeacher);

        return "redirect:/main";
    }

    @GetMapping("/addSchedule")
    public String addSchedule(){



        return "redirect:/main";
    }
}
