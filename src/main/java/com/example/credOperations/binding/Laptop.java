package com.example.credOperations.binding;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Laptop_table")
public class Laptop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer Laptopid;
	private String LaptopName ;
	public String getLaptopName() {
		return LaptopName;
	}
	public void setLaptopName(String laptopName) {
		LaptopName = laptopName;
	}
	public Integer getLaptopid() {
		return Laptopid;
	}
	public void setLaptopid(Integer laptopid) {
		Laptopid = laptopid;
	}
	
	
}
