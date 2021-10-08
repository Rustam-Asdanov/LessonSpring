package com.hibernate.relationship_in_view.controller;

import com.hibernate.relationship_in_view.model.Lessons;
import com.hibernate.relationship_in_view.model.Student;
import com.hibernate.relationship_in_view.model.StudentDetail;
import com.hibernate.relationship_in_view.model.Teacher;
import com.hibernate.relationship_in_view.repository.LessonsRepository;
import com.hibernate.relationship_in_view.repository.StudentDetailRepository;
import com.hibernate.relationship_in_view.repository.StudentRepository;
import com.hibernate.relationship_in_view.repository.TeacherRepository;
import com.hibernate.relationship_in_view.service.BaseService;
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

    private BaseService baseService;

    public MainController(BaseService baseService) {
        this.baseService = baseService;
    }

    @GetMapping
    public String getPage(Model model){

        model.addAttribute("student", new Student());
        model.addAttribute("student_detail",new StudentDetail());
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("lessons",baseService.getLessons());
        model.addAttribute("students",baseService.getStudents());

        return "relationship_in_view/main";
    }

    @GetMapping("/addStudent")
    public String addStudent(
            @ModelAttribute("student") Student theStudent,
            @ModelAttribute("student_detail") StudentDetail theStudentDetail
    ){
        theStudent.setStudentDetail(theStudentDetail);
        baseService.addStudent(theStudent);


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

        baseService.addTeacher(theTeacher);

        return "redirect:/main";
    }

    @GetMapping("/addSchedule")
    public String addSchedule(
            @RequestParam("student_one") String student_one,
            @RequestParam("student_two") String student_two,
            @RequestParam("student_three") String student_three,
            @RequestParam("lesson_one") String lesson_one,
            @RequestParam("lesson_two") String lesson_two,
            @RequestParam("lesson_three") String lesson_three
    ){


       Student studentOne = baseService.getStudentById(Integer.parseInt(student_one));

       Lessons lessonOne = baseService.getLessonById(Integer.parseInt(lesson_one));

       lessonOne.addStudent(studentOne);

       baseService.addLesson(lessonOne);

        Student studentTwo = baseService.getStudentById(Integer.parseInt(student_two));

        Lessons lessonTwo = baseService.getLessonById(Integer.parseInt(lesson_two));

        lessonTwo.addStudent(studentTwo);

        baseService.addLesson(lessonTwo);

        Student studentThree = baseService.getStudentById(Integer.parseInt(student_three));

        Lessons lessonThree = baseService.getLessonById(Integer.parseInt(lesson_three));
        System.out.println("Lesson three is " + lessonThree.getTopic());
        System.out.println("lesson by topic"+ baseService.getLessonByTopic("it").getId());

        lessonThree.addStudent(studentThree);

        baseService.addLesson(lessonThree);

        System.out.println(lesson_one + " " + lesson_two + " " +lesson_three);

        System.out.println("Success");


        return "redirect:/main";
    }
}
