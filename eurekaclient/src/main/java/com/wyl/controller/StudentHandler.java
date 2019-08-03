package com.wyl.controller;

import org.springframework.beans.factory.annotation.Value;
import com.wyl.Student;
import com.wyl.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private  String port;

    @GetMapping("/findAll")
    private Collection<Student> findAll(){
        return  studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public  Student save(@PathVariable("id")long id){
        return  studentRepository.findById(id);
    }

    @PostMapping("/save")
    public  void save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }
    @PutMapping("/update")
    public  void update(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public  void  deleteById(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }

    @GetMapping("index")
    public String index(){
        return  "当前的服务端口是"+this.port;
    }
}
