package com.hibernate.relationship_in_view.service;

import com.hibernate.relationship_in_view.model.Student;
import com.hibernate.relationship_in_view.model.Lessons;
import com.hibernate.relationship_in_view.model.StudentDetail;
import com.hibernate.relationship_in_view.model.Teacher;
import com.hibernate.relationship_in_view.repository.LessonsRepository;
import com.hibernate.relationship_in_view.repository.StudentDetailRepository;
import com.hibernate.relationship_in_view.repository.StudentRepository;
import com.hibernate.relationship_in_view.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseService {

    private LessonsRepository lessonsRepository;
    private StudentRepository studentRepository;
    private StudentDetailRepository studentDetailRepository;
    private TeacherRepository teacherRepository;

    public BaseService(LessonsRepository lessonsRepository, StudentRepository studentRepository, StudentDetailRepository studentDetailRepository, TeacherRepository teacherRepository) {
        this.lessonsRepository = lessonsRepository;
        this.studentRepository = studentRepository;
        this.studentDetailRepository = studentDetailRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Lessons> getLessons() {
        return lessonsRepository.findAll();
    }

    // у нас есть класс DAO
    // public List<Lessons> getLessons(){
    //    return baseDao.getAllLesson();
    //}

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<StudentDetail> getStudentDetails(){
        return studentDetailRepository.findAll();
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addStudent(Student theStudent){
        studentRepository.save(theStudent);
    }

    public void addStudentDetail(StudentDetail theStudentDetail){
        studentDetailRepository.save(theStudentDetail);
    }

    public void addTeacher(Teacher theTeacher){
        teacherRepository.save(theTeacher);
    }

    public void addLesson(Lessons theLesson){
        lessonsRepository.save(theLesson);
    }

    public Student getStudentById(int id){
        return studentRepository.getStudentById(id);
    }

    public Teacher getTeacherById(int id){
        return teacherRepository.getTeacherById(id);
    }

    public Lessons getLessonById(int id){
        return lessonsRepository.getLessonsById(id);
    }

    public Lessons getLessonByTopic(String topic){
        return lessonsRepository.getLessonsByTopic(topic);
    }
}
