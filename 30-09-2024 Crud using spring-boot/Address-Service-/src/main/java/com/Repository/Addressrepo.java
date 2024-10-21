package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.EmpAddress;

@Repository
public interface Addressrepo extends JpaRepository<EmpAddress, Integer>{

}
