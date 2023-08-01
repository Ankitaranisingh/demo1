package com.project1.demo1.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class Studentservice {
    private final StudentRepository studentRepository;
    @Autowired
    public Studentservice(StudentRepository studentRepository){
            this.studentRepository =studentRepository;
    }

    public List<Student> getStudents(){

//        return List.of(new Student(1L,"Ankita", LocalDate.of(2000, Month.APRIL,22),23,"ankita2204.rani@gmail.com"));
//        will get a json resp of the student class list
//        dont return this static list instead call method from repo interface
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        //ELSE SAVE
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent( Long studentId){
           boolean exists =  studentRepository.existsById(studentId);
           if(!exists){
               throw new IllegalStateException("student of ID"+studentId+"does not exists");
           }
           studentRepository.deleteById(studentId);
    }

    @Transactional  //if we dont want to go to reposetory and directly manage here i.e entity goes into managed state
    public void updateStudent(Long studentId , String name, String email){
        Optional<Student> s = studentRepository.findById(studentId);

                 //lambda function,stream API ,java collection
        if(s.isPresent()){
            Student student = s.get();
            if(name!=null &&name.length()>0&&!Objects.equals(student.getName(),name)){
                student.setName(name);
            }
            if (email !=null &&email.length()>0&&!Objects.equals(student.getEmail(),email)){
                Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
                if(studentOptional.isPresent()){
                    System.out.println("Email taken");
                    //throw new IllegalStateException("email taken");
                }
                student.setEmail(email);
            }
        }
       else{
            System.out.println("studentId not present");
        }


    }
}
