package com.dbjpa.sprongboot.jpa.test;

import com.dbjpa.sprongboot.jpa.SpringbootJpaApplication;
import com.dbjpa.sprongboot.jpa.dao.EmpDao;
import com.dbjpa.sprongboot.jpa.pojo.Emp;


;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class EmpTest {
    @Autowired
    private EmpDao empDao;
    @Test
  public   void  testGetOne() {
        Emp one = this.empDao.getOne(1);
        System.out.println("one = " + one);


    }


}
