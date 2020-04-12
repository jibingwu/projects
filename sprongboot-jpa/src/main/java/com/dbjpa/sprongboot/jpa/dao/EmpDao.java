package com.dbjpa.sprongboot.jpa.dao;

import com.dbjpa.sprongboot.jpa.pojo.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpDao extends  JpaRepository<Emp,Integer>, JpaSpecificationExecutor<Emp> {

}
