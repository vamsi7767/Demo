package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Repository.Addressrepo;
import com.model.EmpAddress;

@RestController
@RequestMapping("address")
public class AddressController {
	
	
	@Autowired
	private Addressrepo repo;
	
	@PostMapping
	public ResponseEntity<String>saveEmpAddess (@RequestBody EmpAddress empaddress){
		
		EmpAddress showAddress=repo.save(empaddress);
		
		String res="address"+showAddress.getCity()+showAddress.getState()+showAddress.getVillage();
		
		return new ResponseEntity<String>(res, HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<EmpAddress>>getAllEmployees(){
		
		List<EmpAddress>emp= repo.findAll();
		
		return new ResponseEntity<List<EmpAddress>>(emp, HttpStatus.CONTINUE);
		
	}

}
