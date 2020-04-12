package com.dbjpa.sprongboot.jpa.controller;


import com.dbjpa.sprongboot.jpa.config.ReturnJson;
import com.dbjpa.sprongboot.jpa.dao.EmpDao;
import com.dbjpa.sprongboot.jpa.pojo.Emp;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpDao empDao;   //直接注入 dao层的

    /**
     * 通过占位符的形式查询 /getEemOne/{id}
     *  配合此 @PathVariable("id")
     * @param id
     * @return 返回一条数据
     */
    @GetMapping("/getEemOne/{id}")
    public Object  getEemOne(@PathVariable("id") Integer id){
         Emp one = empDao.getOne(id);
         System.out.println("one = " + one);
         return  one;

     }

    /**
     * 通过请求参数的请形式 @RequestParam
     * @param id
     * @return 返回一条数据
     */
    @GetMapping("/getEemOnes")
    public Object  getEemOnes(@RequestParam Integer id) {
        return  empDao.getOne(id);
    }


    /**
     * 请求查询查询全部
     * @return  返回一个集合
     */
    @GetMapping("/getEemAll")
    public ReturnJson<List<Emp>> getEemAll(){
        List<Emp> all = empDao.findAll();
        System.out.println(all);
        return ReturnJson.success(all);
    }


    /**
     * 通过id删除
     * 先查询结果，然后在删除
     * @param id
     */
    @DeleteMapping("/deleteEmpNone/{id}")
    public  void deleteEmpNne(@PathVariable ("id") Integer id){
        Emp emp = empDao.getOne(id);
        empDao.delete(emp);

    }

    @PostMapping("/updateEmpNone/{id}")
    public  Object updateEmpNone(@PathVariable ("id") Integer id){
        Emp emp = empDao.getOne(id);
        emp.setAge(520);
        Emp em = empDao.save(emp);


        return em;

    }

    @PostMapping("/saveEmp")
    public Object  saveEmp(@RequestBody Emp emp){
        Emp save = empDao.save(emp);
        return save;



    }
    @PutMapping("/modifyById")
    public Object  modifyById(@RequestParam String name ,@RequestParam Integer id ){
        int i = empDao.modifyById(name, id);
        return i;
    }
    
    
    @GetMapping("/findByEmpName/{name}")
    public ReturnJson<Emp>  findByEmpName(@PathVariable("name") String name
    ){
        Emp byUserName = empDao.findByEmpName(name);
        return ReturnJson.success(byUserName);

    }

    @GetMapping("/findByLastName/{name}")
    public ReturnJson< List<Emp>>  findByLastName(@PathVariable("name") String name
    ){
        List<Emp> byLastName = empDao.findByNameLike(name);
        return ReturnJson.success(byLastName);

    }

    /***
     * 通过 name和 age查询
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/findByNameAndAge/{name}/{age}")
    public ReturnJson< List<Emp>>  findByNameAndAge(@PathVariable("name") String name
    , @PathVariable("age") int age){
        List<Emp> byNameAndAge = empDao.findByNameAndAge(name, age);
        return ReturnJson.success(byNameAndAge);

    }


    /**
     * between：
     *
     * @param va1
     * @param va2
     * @return
     *  select emp0_.id as id1_0_, emp0_.age as age2_0_, emp0_.cdate as cdate3_0_, emp0_.name as name4_0_ from emp emp0_ where emp0_.id between ? and ?
     *
     */

    @GetMapping("/findByBetween/{va1}/{va2}")
    public ReturnJson< List<Emp>>  findByBetween(@PathVariable("va1") Integer va1
            , @PathVariable("va2") Integer va2){
        List<Emp> byIdBetween = empDao.findByIdBetween(va1, va2);
        return ReturnJson.success(byIdBetween);

    }

    @PostMapping("/findByIdIn")
    public ReturnJson< List<Emp>>  findByIdIn(@RequestParam List<Integer> ids
           ){
        List<Emp> byIdIn = empDao.findByIdIn(ids);

        return ReturnJson.success(byIdIn);

    }

    @PostMapping("/findByAgeIn")
    public ReturnJson< List<Emp>>  findByAgeIn(@RequestBody List<Integer> ages
    ){
        List<Emp> byIdIn = empDao.findByAgeIn(ages);

        return ReturnJson.success(byIdIn);
    }












}
