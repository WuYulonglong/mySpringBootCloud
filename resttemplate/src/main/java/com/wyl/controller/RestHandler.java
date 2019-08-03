package com.wyl.controller;

import com.wyl.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8869/student/findAll",Collection.class).getBody();
    }
    @GetMapping("/findAll1")
    public  Collection<Student> findAll1(){
        return restTemplate.getForObject("http://localhost:8869/student/findAll",Collection.class);
    }
    @GetMapping("findById/{id}")
    public  Student findById(@PathVariable("id") long id){
        return  restTemplate.getForEntity("http://localhost:8869/student/findById/{id}",Student.class,id).getBody();
    }
    @GetMapping("findById1/id={id}")
    public  Student findById1(@PathVariable("id") long id){
        return  restTemplate.getForObject("http://localhost:8869/student/findById/{id}",Student.class,id);
    }
    @PostMapping("/save")
    public  void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8869/student/save",student,null).getBody();
    }
    @PostMapping("/save1")
    public  void save1(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8869/student/save",student,null);
    }
    @PutMapping("/update")
    public  void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8869/student/update",student);
    }
    @PutMapping("/deleteById")
    public  void deleteById(@PathVariable long id){
        restTemplate.delete("http://localhost:8869/student/deleteById/{id}",id);
    }


}
