package com.dbjpa.sprongboot.jpa.controller;

import com.dbjpa.sprongboot.jpa.config.ReturnJson;
import com.dbjpa.sprongboot.jpa.dao.EmpDao;
import com.dbjpa.sprongboot.jpa.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmpController {
    
    @Autowired
    private EmpDao empDao;
    @GetMapping("/getEemOne/{id}")
    public Object  getEemOne(@PathVariable("id") Integer id){
         Emp one = empDao.getOne(id);
         System.out.println("one = " + one);
         return  one;

     }


    @GetMapping("/getEemOnes")
    public Object  getEemOnes(@RequestParam Integer id) {
        return  empDao.getOne(id);
    }


    @GetMapping("/getEemAll")
    public List<Emp> getEemAll(){
        List<Emp> all = empDao.findAll();
        System.out.println(all);
        return all;
    }







}
