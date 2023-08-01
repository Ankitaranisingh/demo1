package com.project1.demo1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Laye all resources for API
@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    //getstudent mwthod no more api will ask from service layer so create a ref for the same
    private final Studentservice studentservice;

    //student service will be instantiated and injected into this constructor
    //only writing autowired won't work

//    Consider defining a bean of type 'com.project1.demo1.student.Studentservice' in your configuration .will be error so tell the class that needs to be instantiated i.e. make bean
    @Autowired
    public StudentController(Studentservice studentservice) {
        this.studentservice =  studentservice;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentservice.getStudents();

        //return List.of(new Student(1L,"Ankita", LocalDate.of(2000, Month.APRIL,22),23,"ankita2204.rani@gmail.com")); //will get a json resp of the student class list
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){

        studentservice.addNewStudent(student);
    }
    @DeleteMapping(path ="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
            studentservice.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false)String name,
                              @RequestParam(required = false)String email){
        studentservice.updateStudent(studentId,name,email);

    }
}
