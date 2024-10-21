package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rest")
public class EmpAddress {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer address;
	private Integer empid;
	private String village;
	private String city;
	private String state;
	private Integer pin;
	
	
	

}
