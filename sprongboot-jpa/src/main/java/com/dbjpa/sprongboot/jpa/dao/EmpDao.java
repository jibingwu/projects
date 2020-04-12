package com.dbjpa.sprongboot.jpa.dao;

import com.dbjpa.sprongboot.jpa.pojo.Emp;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface EmpDao extends JpaRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {


    @Transactional(timeout = 10)
    @Modifying

    @Query("update Emp set name = ?1 where id = ?2")
    int modifyById(String userName, Integer id);

    @Query(" FROM  Emp WHERE name= ?1")
    Emp findByEmpName(String name);

    @Query("from  Emp u where u.name like CONCAT('%',:name,'%') ")
    List<Emp> findByNameLike(String name);


    //@Query(value = "select * from User as u where u.name=?1 and u.age=?2",nativeQuery = true)
    List<Emp> findByNameAndAge(String name, int age);

    List<Emp> findByIdBetween(Integer va1, Integer va2);

    List<Emp> findByIdIn(List<Integer> ids);


    List<Emp> findByAgeIn(List<Integer> ages);
}
